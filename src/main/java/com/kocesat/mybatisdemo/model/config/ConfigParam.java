package com.kocesat.mybatisdemo.model.config;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigParam implements Serializable{

  private static final long serialVersionUID = 42029319291L;
  private String section;
  private String name;
  private String value;
  private String scope;
}
