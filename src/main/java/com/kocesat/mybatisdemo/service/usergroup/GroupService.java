package com.kocesat.mybatisdemo.service.usergroup;

import com.kocesat.mybatisdemo.model.usergroups.Group;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserGroupDto;
import com.kocesat.mybatisdemo.repo.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

  private final GroupRepository repository;

  public List<Group> findAll() {
    return repository.findAll();
  }

  public Group findById(Integer id) {
    return repository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Group not found"));
  }

  public Group create(UserGroupDto userGroupDto) {
    Group group = Group.from(userGroupDto);
    Optional<Group> groupInDb =
      repository.findByName(group.getName());

    if (groupInDb.isPresent()) {
      throw new IllegalArgumentException("This record has been already defined in the system");
    }

    return repository.create(group);
  }
}
