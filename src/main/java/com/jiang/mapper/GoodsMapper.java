package com.jiang.mapper;

import com.jiang.entity.Goods;
import com.jiang.util.PageQueryUtil;

import java.util.List;

public interface GoodsMapper {
    List<Goods> goodsListSearch(PageQueryUtil pageUtil);

    int getTotal(PageQueryUtil pageUtil);

    Goods selectByPrimaryKey(Long goodsId);
}
