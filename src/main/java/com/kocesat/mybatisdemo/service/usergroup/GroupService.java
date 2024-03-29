package com.kocesat.mybatisdemo.service.usergroup;

import com.kocesat.mybatisdemo.base.exception.BusinessException;
import com.kocesat.mybatisdemo.constant.ErrorCode;
import com.kocesat.mybatisdemo.model.usergroups.Group;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserGroupDto;
import com.kocesat.mybatisdemo.repo.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    try {
      return repository.create(group);
    } catch (DuplicateKeyException e) {
      throw new BusinessException(ErrorCode.DUPLICATE_GROUP);
    }
  }
}
