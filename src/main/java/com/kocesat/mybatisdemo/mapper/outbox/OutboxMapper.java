package com.kocesat.mybatisdemo.mapper.outbox;

import com.kocesat.mybatisdemo.model.outbox.Outbox;
import com.kocesat.mybatisdemo.model.outbox.OutboxUpdateModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OutboxMapper {

  void insert(Outbox outbox);
  int updatePreProcess(OutboxUpdateModel input);
  int updateById(OutboxUpdateModel input);
  List<Outbox> getProcessList(
    @Param("status") Short status,
    @Param("serviceId") Short serviceId,
    @Param("insertTimeStart")LocalDateTime insertTimeStart);
}
