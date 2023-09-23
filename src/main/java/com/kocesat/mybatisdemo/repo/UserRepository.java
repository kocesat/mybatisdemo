package com.kocesat.mybatisdemo.repo;

import com.kocesat.mybatisdemo.mapper.usergroups.UserMapper;
import com.kocesat.mybatisdemo.model.usergroups.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

  private final UserMapper mapper;

  public Optional<User> findByName(String name) {
    List<User> users = mapper.selectByName(name);
    if (users == null || users.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(users.get(0));
  }

  public User create(User user) {
    int count = mapper.insert(user);
    if (count < 1) {
      throw new RuntimeException("Sql create error");
    }
    return user;
  }

  public List<User> selectAll() {
    return mapper.selectAll();
  }
}
