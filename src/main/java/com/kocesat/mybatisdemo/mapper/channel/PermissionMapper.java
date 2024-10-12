package com.kocesat.mybatisdemo.mapper.channel;

import com.kocesat.mybatisdemo.model.channel.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

  int insert(Permission permission);

  List<Permission> select();
}
