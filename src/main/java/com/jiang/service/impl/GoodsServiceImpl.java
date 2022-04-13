package com.jiang.service.impl;

import com.jiang.entity.Goods;
import com.jiang.mapper.GoodsMapper;
import com.jiang.service.GoodsService;
import com.jiang.util.BeanUtil;
import com.jiang.util.PageQueryUtil;
import com.jiang.util.PageResult;
import com.jiang.vo.SearchGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public PageResult search(PageQueryUtil pageUtil) {
        //搜索商品 并且分类
        List<Goods> goodsList = goodsMapper.goodsListSearch(pageUtil);
        int total =goodsMapper.getTotal(pageUtil);
        List<SearchGoodsVO> SearchGoodsVOS =new ArrayList<>();
        if(!CollectionUtils.isEmpty(goodsList)) {
            SearchGoodsVOS = BeanUtil.copyList(goodsList, SearchGoodsVO.class);
            for (SearchGoodsVO newBeeMallSearchGoodsVO :SearchGoodsVOS) {
                String goodsName = newBeeMallSearchGoodsVO.getGoodsName();
                String goodsIntro = newBeeMallSearchGoodsVO.getGoodsIntro();

                if (goodsName.length() > 28) {
                    goodsName = goodsName.substring(0, 28) + "...";
                    newBeeMallSearchGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 30) {
                    goodsIntro = goodsIntro.substring(0, 30) + "...";
                    newBeeMallSearchGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        PageResult pageResult = new PageResult(SearchGoodsVOS, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Goods GoodsById(Long goodsId) {
       Goods goods =goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }
}
