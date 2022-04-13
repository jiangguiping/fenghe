package com.jiang.controller;

import com.jiang.common.Result;
import com.jiang.entity.Goods;
import com.jiang.service.GoodsService;
import com.jiang.util.PageQueryUtil;
import com.jiang.vo.GoodsDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.jiang.util.PageResult;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/vi")
public class GoodsAPI {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/search")
    public Result search(@RequestParam(required = false) String keyword,
                         @RequestParam(required = false) Long goods,
                         @RequestParam(required = false) String orderBy,
                         @RequestParam(required = false) Integer pageNumber) {
        Map params = new HashMap(8);
        if (goods == null && StringUtils.isEmpty(keyword)) {
            return Result.fail("非法的搜索参数");
        }
        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        params.put("goodsCategoryId",goods);
        params.put("page",pageNumber);
        params.put("limit",10);
        if (!StringUtils.isEmpty(keyword)) {//判断keyword是否为空
            params.put("keyword", keyword);
        }
        if (!StringUtils.isEmpty(orderBy)) {//判断 分类数据是否为空
            params.put("orderBy", orderBy);
        }
        params.put("goodsSellStatus", 0);
        PageQueryUtil pageUtil = new PageQueryUtil(params);

        PageResult hh=goodsService.search(pageUtil);
        return Result.succ(hh);
    }

    //商品详情
    @GetMapping("/goods/detail/{goodsId}")
    public Result goodsDetail(@PathVariable("goodsId") Long goodsId) {
        if(goodsId < 1 ) {
            return Result.fail("参数异常");
        }
        Goods goods =goodsService.GoodsById(goodsId);
        GoodsDetailVO goodsDetailVO=new GoodsDetailVO();
        BeanUtils.copyProperties(goods, goodsDetailVO);
        goodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
        return Result.succ(goods);
    }

    @GetMapping("/git")
    public Result git() {
        return Result.succ("提交");
    }
    //第三次提交
    @GetMapping("/jiji")
    public Result jiji() {
        return Result.succ("提交");
    }


}
