package com.stringeex.sample.rest.index;

import com.stringeex.sample.core.base.BaseController;
import com.stringeex.sample.rest.index.domain.IndexRes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Validated
@RestController("")
public class IndexController extends BaseController {

    @GetMapping("")
    public IndexRes index() {
        throw new RuntimeException("Just exception for testing");
//        IndexRes res = new IndexRes();
//        res.setCode(200);
//        res.setMessages("Successfully");
//        res.setTimestamp(new Date());
//        return res;
    }
}
