package com.kocesat.mybatisdemo.service.config;

import com.kocesat.mybatisdemo.model.config.ConfigParam;
import com.kocesat.mybatisdemo.repo.config.ConfigParamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConfigParamService {

  private final ConfigParamRepository repository;

  @Cacheable(value = "configParamValue", key = "#section+#name")
  public ConfigParam get(String section, String name) {
    return repository.getBySectionAndName(section, name)
      .orElse(null);
  }

  @Cacheable(value = "configParamSection", key = "#section")
  public Map<String, String> get(String section) {
    List<ConfigParam> configParams = repository.getBySection(section);
    Map<String, String> configMap = new HashMap<>(configParams.size() + 2, 1F);
    configParams.forEach(configParam -> configMap.put(configParam.getName(), configParam.getValue()));
    return configMap;
  }

  @CacheEvict(cacheNames = "configParamSection", key = "#param.section")
  public boolean create(ConfigParam param) {
    return repository.insert(param) == 1;
  }

  @Caching(
    evict = {
      @CacheEvict(cacheNames = "configParamSection", key = "#param.section"),
      @CacheEvict(cacheNames = "configParamValue", key = "#param.section+#param.name")
    }
  )
  public boolean update(ConfigParam param) {
    return repository.update(param) == 1;
  }
}
