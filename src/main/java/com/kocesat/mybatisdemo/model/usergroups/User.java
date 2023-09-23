package com.kocesat.mybatisdemo.model.usergroups;

import com.kocesat.mybatisdemo.model.usergroups.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer id;
  private String name;
  private boolean active;

  public static User from(UserDto dto) {
    return User.builder()
      .id(dto.getId())
      .name(dto.getName())
      .active(true)
      .build();
  }

  public static User ofId(Integer id) {
    return User.builder()
      .id(id)
      .active(true)
      .build();
  }

  public UserDto toDto() {
    return UserDto.builder()
      .name(name)
      .id(id)
      .build();
  }
}
