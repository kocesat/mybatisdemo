package com.kocesat.mybatisdemo.service.config;

import com.kocesat.mybatisdemo.model.config.ConfigParam;
import com.kocesat.mybatisdemo.repo.config.FlagDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlagService {

  private static final String REDIRECT_FIRM_SECTION = "MYAPP_V2_REDIRECT_FIRM";
  private static final String REDIRECT_ALL_SECTION = "MYAPP_V2";
  private static final String REDIRECT_ALL_NAME = "REDIRECT_FLAG";
  private final ConfigParamService configService;

  public Boolean checkFlag(FlagDto dto) {
    String companyId = dto.getCompanyId().toString();
    Map<String, String> companyRedirectMap = configService.get(REDIRECT_FIRM_SECTION);
    if (companyRedirectMap.containsKey(companyId)) {
      return "true".equals(companyRedirectMap.get(companyId));
    }
    ConfigParam redirectAllConfig = configService.get(REDIRECT_ALL_SECTION, REDIRECT_ALL_NAME);
    return redirectAllConfig != null && "true".equals(redirectAllConfig.getValue());
  }
}
