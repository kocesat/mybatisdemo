package com.kocesat.mybatisdemo.controller;

import com.kocesat.mybatisdemo.model.config.ConfigParam;
import com.kocesat.mybatisdemo.service.config.ConfigParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config-param")
@RequiredArgsConstructor
public class ConfigParamController {

  private final ConfigParamService configParamService;

  @PostMapping
  public Boolean create(@RequestBody ConfigParam configParam) {
    return configParamService.create(configParam);
  }

  @PutMapping
  public Boolean update(@RequestBody ConfigParam configParam) {
    return configParamService.update(configParam);
  }
}
