package com.kocesat.mybatisdemo.repo.config;

import com.kocesat.mybatisdemo.mapper.config.ConfigParamMapper;
import com.kocesat.mybatisdemo.model.config.ConfigParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConfigParamRepository {

  private final ConfigParamMapper mapper;

  public List<ConfigParam> getBySection(String section) {
    ConfigParam configParam = ConfigParam.builder()
      .section(section)
      .build();
    return mapper.select(configParam);
  }

  public Optional<ConfigParam> getBySectionAndName(String section, String name) {
    ConfigParam configParam = ConfigParam.builder()
      .section(section)
      .name(name)
      .build();
    List<ConfigParam> configParams = mapper.select(configParam);
    if (configParams.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(configParams.get(0));
  }

  public int insert(ConfigParam param) {
    return mapper.insert(param);
  }

  public int update(ConfigParam param) {
    return mapper.update(param);
  }
}
