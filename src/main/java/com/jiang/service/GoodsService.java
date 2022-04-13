package com.jiang.service;

import com.jiang.entity.Goods;
import com.jiang.util.PageQueryUtil;
import com.jiang.util.PageResult;

public interface GoodsService {
    PageResult search(PageQueryUtil pageUtil);

    //获取商品详情
    Goods GoodsById(Long goodsId);
}
