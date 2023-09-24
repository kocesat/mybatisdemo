package com.kocesat.mybatisdemo.mapper.usergroups;

import com.kocesat.mybatisdemo.model.usergroups.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {

  List<Group> selectAll();
  List<Group> selectByName(String name);
  List<Group> selectById(Integer id);
  int countById(Integer id);
  int insert(Group group);
}
