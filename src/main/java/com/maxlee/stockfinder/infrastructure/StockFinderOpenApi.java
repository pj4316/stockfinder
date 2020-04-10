package com.maxlee.stockfinder.infrastructure;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxlee.stockfinder.domain.IsinCode;
import com.maxlee.stockfinder.domain.StockInfo;
import com.maxlee.stockfinder.infrastructure.exception.OpenApiUriSyntaxException;
import com.maxlee.stockfinder.infrastructure.model.GetStockInfoReq;
import com.maxlee.stockfinder.infrastructure.model.GetStockInfoRes;
import com.maxlee.stockfinder.service.StockFinder;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@Service
public class StockFinderOpenApi implements StockFinder {

  @Value(value = "${open.api.access.key}")
  private String accessKey = "PKken49Nd3usevRc3UWoyS3L7xmEeXA%2BZnQyjNqzA3R%2FzIUYLtIS2iIMpnMj%2Bi8p83oiF6uhUs25cxpkuC3pqw%3D%3D";

  @Value(value = "${stock.service.baseUrl}")
  private String baseUrl = "http://api.seibro.or.kr/openapi/service/StockSvc?_wadl&type=xml";

  @Value(value = "${stock.service.list.info.path}")
  private String stockInfoListPath = "getStkListInfoN1";

  @Override
  public StockInfo getStockInfo(IsinCode isinCode) {
    ResponseEntity<GetStockInfoRes> response = getStockInfoListRestTemplate(isinCode);

    if (response.getStatusCode().is2xxSuccessful()) {
      GetStockInfoRes result = response.getBody();

      return result == null ? null : result.getStockInfo();
    } else {
      return null;
    }
  }

  private ResponseEntity<GetStockInfoRes> getStockInfoListRestTemplate(IsinCode isinCode) {
    try {
      System.out.println(baseUrl);
      System.out.println(stockInfoListPath);

      String path = Strings.join(Arrays.asList(baseUrl, stockInfoListPath), '/');

      URI uri = new URI(path);

      System.out.println(uri.toString());

      RestTemplate restTemplate = new RestTemplate();
      MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

      converter.setObjectMapper(objectMapper);
      restTemplate.getMessageConverters().add(0, converter);

      GetStockInfoReq req = new GetStockInfoReq(accessKey, 0, 50, isinCode.getCode());

      return restTemplate.postForEntity(uri, req, GetStockInfoRes.class);
    } catch (URISyntaxException e) {
      throw new OpenApiUriSyntaxException(e);
    }
  }
}
