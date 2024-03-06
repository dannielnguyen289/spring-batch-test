package com.stringeex.sample.rest.sample.impl;

import com.stringeex.sample.core.base.BaseService;
import com.stringeex.sample.core.pagination.Paginator;
import com.stringeex.sample.rest.sample.SampleRepository;
import com.stringeex.sample.rest.sample.SampleService;
import com.stringeex.sample.rest.sample.domain.Entity;
import com.stringeex.sample.rest.sample.domain.ListEntityRes;
import com.stringeex.sample.rest.sample.query.SelectEntityPrt;
import com.stringeex.sample.rest.sample.query.SelectEntityRss;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleServiceImpl extends BaseService implements SampleService {

    @Autowired
    SampleRepository sampleRepository;

    @Override
    public ListEntityRes getList(Long pageNo, Integer pageSize) {

        // Declare result
        ListEntityRes listEntityRes =  new ListEntityRes();

        // Pagination
        Paginator paginator = new Paginator(pageNo, pageSize);

        // Select param
        SelectEntityPrt params = new SelectEntityPrt();
        params.setLimit(paginator.getLimit());
        params.setOffset(paginator.getOffset());

        // Count total records
        Long count = sampleRepository.count(params);

        if (count <= 0) {
            listEntityRes.setPagination(paginator.toPagination());
            return listEntityRes;
        }

        List<SelectEntityRss> listResultSet = sampleRepository.list(params);

        List<Entity> listEntity = new ArrayList<>();
        for(SelectEntityRss item: listResultSet) {
            Entity entity = new Entity();
            BeanUtils.copyProperties(item, entity);
            listEntity.add(entity);
        }

        listEntityRes.setList(listEntity);
        listEntityRes.setPagination(paginator.toPagination());

        return listEntityRes;
    }
}
