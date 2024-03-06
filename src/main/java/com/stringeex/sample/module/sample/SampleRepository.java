package com.stringeex.sample.module.sample;

import com.stringeex.sample.module.sample.query.InsertEntityPrt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleRepository {
    void insert(InsertEntityPrt params);
}
