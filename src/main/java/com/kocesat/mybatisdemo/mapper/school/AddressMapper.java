package com.kocesat.mybatisdemo.mapper.school;

import com.kocesat.mybatisdemo.model.school.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

  void insert(Address address);
  List<Address> findAll();
  List<Address> findById(Integer id);
}
