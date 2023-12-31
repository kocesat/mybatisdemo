package com.kocesat.mybatisdemo.controller;

import com.kocesat.mybatisdemo.repo.config.FlagDto;
import com.kocesat.mybatisdemo.service.config.FlagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flag-check")
@RequiredArgsConstructor
public class FlagController {

  private final FlagService flagService;

  @GetMapping
  public Boolean getFlag(@RequestBody FlagDto dto) {
    return flagService.checkFlag(dto);
  }
}
