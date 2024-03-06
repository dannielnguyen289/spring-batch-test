package com.stringeex.rest.sample;

import com.stringeex.rest.sample.query.SelectEntityPrt;
import com.stringeex.rest.sample.query.SelectEntityRss;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleRestRepository {
    Long count(SelectEntityPrt params);

    List<SelectEntityRss> list(SelectEntityPrt params);
}
