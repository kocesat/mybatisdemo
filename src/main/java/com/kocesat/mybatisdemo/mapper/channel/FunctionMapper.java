package com.kocesat.mybatisdemo.mapper.channel;

import com.kocesat.mybatisdemo.model.channel.Function;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FunctionMapper {
    int deleteByPrimaryKey(String code);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}