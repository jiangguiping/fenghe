package com.jiang.mapper;

import com.jiang.entity.GoodsCategory;
import com.jiang.vo.IndexCategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {

    List<IndexCategoryVO> add();
}
