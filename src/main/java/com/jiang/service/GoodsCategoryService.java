package com.jiang.service;

import com.jiang.entity.GoodsCategory;
import com.jiang.vo.IndexCategoryVO;

import java.util.List;

public interface GoodsCategoryService {

    List<IndexCategoryVO> getCategoriesForIndex();
}
