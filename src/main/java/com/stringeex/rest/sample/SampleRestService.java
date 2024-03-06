package com.stringeex.rest.sample;

import com.stringeex.rest.sample.domain.ListEntityRes;

public interface SampleRestService {
    ListEntityRes getList(Long pageNo, Integer pageSize);
}
