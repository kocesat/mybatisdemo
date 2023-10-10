package com.kocesat.mybatisdemo.service.school;

import com.kocesat.mybatisdemo.mapper.school.FeePaymentMapper;
import com.kocesat.mybatisdemo.model.school.FeePayment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeePaymentService {

  private final FeePaymentMapper mapper;

  public List<FeePayment> getAll() {
    return mapper.findAll();
  }
}
