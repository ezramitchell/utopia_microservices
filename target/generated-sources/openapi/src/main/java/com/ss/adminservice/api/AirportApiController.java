package com.ss.adminservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-20T15:45:31.821814900-06:00[America/Denver]")
@Controller
@RequestMapping("${openapi.utopia.base-path:}")
public class AirportApiController implements AirportApi {

    private final AirportApiDelegate delegate;

    public AirportApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) AirportApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AirportApiDelegate() {});
    }

    @Override
    public AirportApiDelegate getDelegate() {
        return delegate;
    }

}
