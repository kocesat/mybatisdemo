package com.kocesat.mybatisdemo.mapper.usergroups;

import com.kocesat.mybatisdemo.model.usergroups.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

  int insert(User user);

  List<User> selectByName(String name);

  List<User> selectAll();

  int deleteById(Integer id);
}
