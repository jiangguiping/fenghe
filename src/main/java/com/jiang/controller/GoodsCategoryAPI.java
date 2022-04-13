package com.jiang.controller;

import com.jiang.common.Result;
import com.jiang.common.ServiceResultEnum;
import com.jiang.entity.GoodsCategory;
import com.jiang.service.GoodsCategoryService;
import com.jiang.vo.IndexCategoryVO;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/vi")
public class GoodsCategoryAPI {
    @Resource
    private GoodsCategoryService goodsCategoryService;

    @GetMapping("/categories")
    public Result getCategories() {
        List<IndexCategoryVO> categories = goodsCategoryService.getCategoriesForIndex();

        return Result.succ(categories);
    }

}
