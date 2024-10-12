package com.kocesat.mybatisdemo.service.channel;

import com.kocesat.mybatisdemo.model.channel.Permission;
import com.kocesat.mybatisdemo.repo.channel.PermissionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionService {

  private final PermissionRepository permissionRepository;

  public Permission createPermission(Permission permission) {
    permission.setStatus(1);
    return permissionRepository.create(permission);
  }

  public List<Permission> findAllPermissions() {
    return permissionRepository.findAll();
  }
}
