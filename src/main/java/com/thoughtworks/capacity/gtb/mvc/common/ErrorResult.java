package com.thoughtworks.capacity.gtb.mvc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/9/10 8:08
 * @Description ***
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    private Integer code;
    private String errorMessage;
}
