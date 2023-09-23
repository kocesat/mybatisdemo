package com.kocesat.mybatisdemo.controller.usergroup;

import com.kocesat.mybatisdemo.model.usergroups.User;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserDto;
import com.kocesat.mybatisdemo.service.usergroup.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<UserDto> getAll() {
    return userService.findAll().stream()
      .map(User::toDto)
      .toList();
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }
}
