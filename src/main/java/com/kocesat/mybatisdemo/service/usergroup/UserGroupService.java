package com.kocesat.mybatisdemo.service.usergroup;

import com.kocesat.mybatisdemo.model.usergroups.Group;
import com.kocesat.mybatisdemo.model.usergroups.User;
import com.kocesat.mybatisdemo.model.usergroups.UserGroup;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserDto;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserGroupDto;
import com.kocesat.mybatisdemo.repo.UserGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UserGroupService {

  private final UserService userService;
  private final GroupService groupService;
  private final UserGroupRepository userGroupRepository;

  public UserGroupDto findByGroupId(Integer groupId) {
    final List<UserGroup> userGroupList = userGroupRepository.findByGroupId(groupId);
    if (userGroupList.isEmpty()) {
      return UserGroupDto.builder()
        .group(null)
        .users(Collections.emptyList())
        .build();
    }
    List<UserDto> userDtos = new ArrayList<>();
    for (UserGroup userGroup : userGroupList) {
      userDtos.add(userGroup.getUser().toDto());
    }

    userGroupList.get(0).getGroup().setMemberCount(userDtos.size());
    return UserGroupDto.builder()
      .users(userDtos)
      .group(userGroupList.get(0).getGroup().toDto())
      .build();
  }

  public void updateGroupWithUsersV2(UserGroupDto userGroupDto) {
    final Group group = groupService.findById(userGroupDto.getGroup().getId());

    userGroupRepository.deactivateByGroupId(group.getId());

    List<User> activeUsers = userService.findAll();

    List<UserGroup> userGroupsToAdd = userGroupDto.getUsers()
      .stream()
      .filter(userDto -> contains(activeUsers, userDto))
      .map(userDto -> UserGroup.builder()
        .group(group)
        .active(true)
        .user(User.from(userDto))
        .build())
      .toList();

      userGroupRepository.saveAll(userGroupsToAdd);
  }

  public void deactivateByUserId(Integer userId) {
    userGroupRepository.deactivateByUserId(userId);
  }

  @Deprecated(since = "V2", forRemoval = true)
  public void updateGroupWithUsers(UserGroupDto userGroupDto) {
    final Group group = groupService.findById(userGroupDto.getGroup().getId());
    List<UserGroup> actives = userGroupRepository.findByGroupId(group.getId());
    List<UserGroup> inactives = userGroupRepository.findInactivesByGroupId(group.getId());
    List<User> activeUsers = userService.findAll();

    List<Integer> finalUserIdList = userGroupDto.getUsers()
      .stream()
      .filter(userDto -> contains(activeUsers, userDto))
      .map(UserDto::getId)
      .toList();

    List<Integer> activationList = finalUserIdList
      .stream()
      .filter(userId -> containedInRelation(userId, inactives))
      .toList();

    List<Integer> creationList = finalUserIdList
      .stream()
      .filter(userId -> !containedInRelation(userId, actives))
      .toList();

    List<Integer> deactivationList = actives.stream()
      .filter(userGroup -> !finalUserIdList.contains(userGroup.getUser().getId()))
      .map(userGroup -> userGroup.getUser().getId())
      .toList();

    userGroupRepository.saveAll(creationList.stream()
      .map(id -> UserGroup.builder()
        .user(User.ofId(id))
        .group(Group.ofId(group.getId()))
        .active(true)
        .build())
      .toList());

    userGroupRepository.activeByGroupIdAndUserId(group.getId(), activationList);
    userGroupRepository.deactivateByGroupIdAndUserId(group.getId(), deactivationList);
  }

  public void createGroupWithUsers(UserGroupDto userGroupDto) {
    if (userGroupDto.getUsers() == null
      || userGroupDto.getUsers().isEmpty()) {
      throw new IllegalArgumentException("Chose at least one user to add this group!");
    }
    final Group group = groupService.create(userGroupDto);
    List<User> activeUsers = userService.findAll();
    List<UserDto> usersToAdd = userGroupDto.getUsers().stream()
      .filter(userDto -> contains(activeUsers, userDto))
      .toList();

    List<UserGroup> userGroupList = usersToAdd
      .stream()
      .map(userDto -> UserGroup.builder()
        .active(true)
        .group(group)
        .user(User.from(userDto))
        .build())
      .toList();

    int count = userGroupRepository.saveAll(userGroupList);
    if (count < userGroupList.size()) {
      throw new IllegalStateException("cannot insert all records");
    }
  }

  public UserGroup create(UserGroup userGroup) {
    return userGroupRepository.create(userGroup);
  }

  private boolean contains(List<User> users, UserDto dto) {
    return users.stream()
      .anyMatch(user -> user.getId().equals(dto.getId()));
  }

  private boolean containedInRelation(Integer userId, List<UserGroup> userGroupList) {
    return userGroupList.stream()
      .anyMatch(userGroup -> userGroup.getUser().getId().equals(userId));
  }
}
