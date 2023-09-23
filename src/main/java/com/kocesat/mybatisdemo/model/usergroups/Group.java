package com.kocesat.mybatisdemo.model.usergroups;

import com.kocesat.mybatisdemo.model.usergroups.dto.GroupDto;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserDto;
import com.kocesat.mybatisdemo.model.usergroups.dto.UserGroupDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {

  private Integer id;
  private String name;
  private boolean active;

  public static Group from(UserGroupDto dto) {
    return Group.builder()
      .active(true)
      .id(dto.getGroup().getId())
      .name(dto.getGroup().getName())
      .build();
  }

  public static Group ofId(Integer id) {
    return Group.builder()
      .id(id)
      .active(true)
      .build();
  }

  public GroupDto toDto() {
    return GroupDto.builder()
      .id(id)
      .name(name)
      .build();
  }
}
