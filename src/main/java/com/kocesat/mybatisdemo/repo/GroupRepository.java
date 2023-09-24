package com.kocesat.mybatisdemo.repo;

import com.kocesat.mybatisdemo.mapper.usergroups.GroupMapper;
import com.kocesat.mybatisdemo.model.usergroups.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GroupRepository {

  private final GroupMapper groupMapper;

  public List<Group> findAll() {
    return groupMapper.selectAll();
  }

  public Optional<Group> findByName(final String name) {
    List<Group> groups = groupMapper.selectByName(name);
    if (groups == null || groups.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(groups.get(0));
  }

  public Group create(Group group) {
    int count = groupMapper.insert(group);
    if (count < 1) {
      throw new RuntimeException("Sql insert error");
    }
    return group;
  }

  public Optional<Group> findById(Integer id) {
    List<Group> group = groupMapper.selectById(id);
    if (group.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(group.get(0));
  }

  public int countById(Integer id) {
    return groupMapper.countById(id);
  }
}
