package com.kocesat.mybatisdemo.mapper.config;

import com.kocesat.mybatisdemo.model.config.ConfigParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConfigParamMapper {

  List<ConfigParam> select(ConfigParam param);

  int insert(ConfigParam param);

  int update(ConfigParam param);
}
