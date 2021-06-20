package com.ss.adminservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T20:36:03.845684600-06:00[America/Denver]")
@Controller
@RequestMapping("${openapi.utopia.base-path:}")
public class AirplaneTypeApiController implements AirplaneTypeApi {

    private final AirplaneTypeApiDelegate delegate;

    public AirplaneTypeApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) AirplaneTypeApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AirplaneTypeApiDelegate() {});
    }

    @Override
    public AirplaneTypeApiDelegate getDelegate() {
        return delegate;
    }

}
