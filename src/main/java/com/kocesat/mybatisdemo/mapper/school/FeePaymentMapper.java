package com.kocesat.mybatisdemo.mapper.school;

import com.kocesat.mybatisdemo.model.school.FeePayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeePaymentMapper {

  List<FeePayment> findAll();
}
