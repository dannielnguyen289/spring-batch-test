package com.stringeex.services.index.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexRes {
    Integer code;
    String messages;
    Date timestamp;
}
