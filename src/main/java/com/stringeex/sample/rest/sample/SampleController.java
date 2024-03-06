package com.stringeex.sample.rest.sample;

import com.stringeex.sample.rest.sample.domain.ListEntityRes;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController("/entity")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping
    public ListEntityRes getList(@RequestParam(name = "pageNo", defaultValue = "1") @Min(1) Long pageNo,
                                 @RequestParam(name = "pageSize", defaultValue = "10") @Min(1) @Max(10) Integer pageSize) {
        return sampleService.getList(pageNo, pageSize);
    }
}
