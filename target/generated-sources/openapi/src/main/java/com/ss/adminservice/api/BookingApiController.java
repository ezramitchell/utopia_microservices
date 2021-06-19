package com.ss.adminservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-19T12:52:51.050113-06:00[America/Denver]")
@Controller
@RequestMapping("${openapi.utopia.base-path:}")
public class BookingApiController implements BookingApi {

    private final BookingApiDelegate delegate;

    public BookingApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) BookingApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new BookingApiDelegate() {});
    }

    @Override
    public BookingApiDelegate getDelegate() {
        return delegate;
    }

}
