package com.kocesat.mybatisdemo.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentIdListWrapper {
  private List<Integer> idList;
}
