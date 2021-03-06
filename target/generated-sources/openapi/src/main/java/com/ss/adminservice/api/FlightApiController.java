package com.ss.adminservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-20T15:45:31.821814900-06:00[America/Denver]")
@Controller
@RequestMapping("${openapi.utopia.base-path:}")
public class FlightApiController implements FlightApi {

    private final FlightApiDelegate delegate;

    public FlightApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) FlightApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FlightApiDelegate() {});
    }

    @Override
    public FlightApiDelegate getDelegate() {
        return delegate;
    }

}
