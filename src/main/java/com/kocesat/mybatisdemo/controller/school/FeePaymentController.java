package com.kocesat.mybatisdemo.controller.school;

import com.kocesat.mybatisdemo.model.school.FeePayment;
import com.kocesat.mybatisdemo.service.school.FeePaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/fee-payments")
@RequiredArgsConstructor
public class FeePaymentController {
  private final FeePaymentService feePaymentService;

  @GetMapping
  public List<FeePayment> getAll() {
    return feePaymentService.getAll();
  }

}
