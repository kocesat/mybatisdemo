package com.kocesat.mybatisdemo.repo;

import com.kocesat.mybatisdemo.mapper.usergroups.UserGroupMapper;
import com.kocesat.mybatisdemo.model.usergroups.UserGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserGroupRepository {

  private final UserGroupMapper mapper;

  public List<UserGroup> findByGroupId(Integer groupId) {
    return mapper.selectByGroupId(groupId);
  }

  public List<UserGroup> findInactivesByGroupId(Integer groupId) {
    return mapper.selectInactivesByGroupId(groupId);
  }

  public int saveAll(List<UserGroup> userGroupList) {
    return mapper.insertAll(userGroupList);
  }

  public UserGroup create(UserGroup userGroup) {
    int count = mapper.insert(userGroup);
    if (count < 1) {
      throw new RuntimeException("Sql insert error");
    }
    return userGroup;
  }

  public int activeByGroupIdAndUserId(Integer id, List<Integer> activationList) {
    if (activationList.isEmpty()) {
      return 0;
    }
    return mapper.activateByGroupIdAndUserIdList(id, activationList);
  }

  public int deactivateByGroupIdAndUserId(Integer id, List<Integer> deactivationList) {
    if (deactivationList.isEmpty()) {
      return 0;
    }
    return mapper.deactivateByGroupIdAndUserIdList(id, deactivationList);
  }

  public int deactivateByGroupId(Integer groupId) {
    return mapper.deactivateByGroupId(groupId);
  }

  public int deactivateByUserId(Integer userId) {
    return mapper.deactivateByUserId(userId);
  }
}
