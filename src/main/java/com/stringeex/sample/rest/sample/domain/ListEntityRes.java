package com.stringeex.sample.rest.sample.domain;

import com.stringeex.sample.core.pagination.Pagination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListEntityRes {
    List<Entity> list = new ArrayList<>();
    Pagination pagination = new Pagination();
}
