package com.kocesat.mybatisdemo.service.usergroup;

import com.kocesat.mybatisdemo.model.usergroups.User;
import com.kocesat.mybatisdemo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User createUser(User user) {
    if (userRepository.findByName(user.getName()).isPresent()) {
      throw new IllegalArgumentException("This record has been already defined in the system.");
    }
    return userRepository.create(user);
  }

  public List<User> findAll() {
    return userRepository.selectAll();
  }
}
