package com.kocesat.mybatisdemo.mapper.usergroups;

import com.kocesat.mybatisdemo.model.usergroups.UserGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserGroupMapper {

  int insert(UserGroup userGroup);
  int insertAll(List<UserGroup> userGroupList);
  List<UserGroup> selectByGroupId(@Param("groupId") Integer groupId);
  List<UserGroup> selectInactivesByGroupId(Integer groupId);
  int deactivateByGroupId(Integer groupId);
  int deactivateByUserId(Integer userId);
  int activateByGroupIdAndUserIdList(@Param("groupId") Integer id,
                                     @Param("activationList") List<Integer> activationList);
  int deactivateByGroupIdAndUserIdList(@Param("groupId") Integer id,
                                       @Param("deactivationList") List<Integer> deactivationList);
}
