package com.kocesat.mybatisdemo.repo.channel;

import com.kocesat.mybatisdemo.mapper.channel.PermissionMapper;
import com.kocesat.mybatisdemo.model.channel.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PermissionRepository {

  private final PermissionMapper mapper;

  public List<Permission> findAll() {
    return mapper.select();
  }

  public Permission create(Permission permission) {
    mapper.insert(permission);
    return permission;
  }
}
