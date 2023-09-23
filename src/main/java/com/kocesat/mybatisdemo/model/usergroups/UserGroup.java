package com.kocesat.mybatisdemo.model.usergroups;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup {

  private Integer id;
  private User user;
  private Group group;
  private boolean active;
}
