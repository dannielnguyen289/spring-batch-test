package com.stringeex.sample.rest.sample;

import com.stringeex.sample.rest.sample.query.SelectEntityPrt;
import com.stringeex.sample.rest.sample.query.SelectEntityRss;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleRepository {
    Long count(SelectEntityPrt params);

    List<SelectEntityRss> list(SelectEntityPrt params);
}
