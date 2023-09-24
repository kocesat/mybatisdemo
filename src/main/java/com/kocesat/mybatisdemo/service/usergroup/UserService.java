package com.kocesat.mybatisdemo.service.usergroup;

import com.kocesat.mybatisdemo.model.usergroups.User;
import com.kocesat.mybatisdemo.repo.UserGroupRepository;
import com.kocesat.mybatisdemo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

  private final UserRepository userRepository;
  private final UserGroupRepository userGroupRepository;

  public User createUser(User user) {
    try {
      return userRepository.create(user);
    } catch (DuplicateKeyException e) {
      throw new IllegalArgumentException("This user has already been defined in the system");
    }
  }

  public List<User> findAll() {
    return userRepository.selectAll();
  }

  public void delete(Integer id) {
    userRepository.deleteById(id);
    userGroupRepository.deactivateByUserId(id);
  }
}
