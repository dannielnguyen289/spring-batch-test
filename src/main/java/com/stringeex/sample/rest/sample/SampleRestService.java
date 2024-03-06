package com.stringeex.sample.rest.sample;

import com.stringeex.sample.rest.sample.domain.ListEntityRes;

public interface SampleRestService {
    ListEntityRes getList(Long pageNo, Integer pageSize);
}
