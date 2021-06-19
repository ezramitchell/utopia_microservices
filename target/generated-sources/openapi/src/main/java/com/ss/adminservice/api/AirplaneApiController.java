package com.ss.adminservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T12:52:51.050113-06:00[America/Denver]")
@Controller
@RequestMapping("${openapi.utopia.base-path:}")
public class AirplaneApiController implements AirplaneApi {

    private final AirplaneApiDelegate delegate;

    public AirplaneApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) AirplaneApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AirplaneApiDelegate() {});
    }

    @Override
    public AirplaneApiDelegate getDelegate() {
        return delegate;
    }

}
