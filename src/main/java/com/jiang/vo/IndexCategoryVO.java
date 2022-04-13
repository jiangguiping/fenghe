package com.jiang.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 首页分类数据VO
 */
@Data
public class IndexCategoryVO implements Serializable {

    private Long categoryId;//分类id

    private Byte categoryLevel;//分类级别

    private Long parentId;

    private String categoryName; //分类名称

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IndexCategoryVO> children;
}
