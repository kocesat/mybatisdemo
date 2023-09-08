package com.kocesat.mybatisdemo.repo;

import com.kocesat.mybatisdemo.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressRepository {

  void insert(Address address);
  List<Address> findAll();
  List<Address> findById(Integer id);
}
