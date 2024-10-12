package com.kocesat.mybatisdemo.controller.channel;

import com.kocesat.mybatisdemo.model.channel.Permission;
import com.kocesat.mybatisdemo.service.channel.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/permission")
@RequiredArgsConstructor
public class PermissionController {

  private final PermissionService permissionService;

  @PostMapping
  public ResponseEntity<Permission> create(@RequestBody @Validated Permission permission) {
    Permission permissionSaved = permissionService.createPermission(permission);
    URI location = URI.create("/api/v1/permission/" + permissionSaved.getCode());
    return ResponseEntity.created(location).build();
  }

  @GetMapping
  public ResponseEntity<List<Permission>> findAll() {
    return ResponseEntity.ok(permissionService.findAllPermissions());
  }
}
