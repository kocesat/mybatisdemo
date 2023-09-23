package com.kocesat.mybatisdemo.controller.usergroup;

import com.kocesat.mybatisdemo.model.usergroups.Group;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserGroupDto;
import com.kocesat.mybatisdemo.service.usergroup.GroupService;
import com.kocesat.mybatisdemo.service.usergroup.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

  private final GroupService groupService;
  private final UserGroupService userGroupService;

  @GetMapping
  public List<Group> getAll() {
    return groupService.findAll();
  }

  @GetMapping("/{id}")
  public UserGroupDto getGroupUsers(@PathVariable("id") Integer groupId) {
    return userGroupService.findByGroupId(groupId);
  }

  @PostMapping
  public Group createGroup(@RequestBody UserGroupDto userGroupDto) {
    return groupService.create(userGroupDto);
  }

  @PostMapping("/with-users")
  public void createWithUsers(@RequestBody UserGroupDto userGroupDto) {
    userGroupService.createGroupWithUsers(userGroupDto);
  }

  @PutMapping("/with-users")
  public void updateWithUsers(@RequestBody UserGroupDto userGroupDto) {
    userGroupService.updateGroupWithUsers(userGroupDto);
  }
}
