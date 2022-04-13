package com.jiang.controller;

import com.jiang.common.Result;
import com.jiang.entity.CategoryEntity;
import com.jiang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//商品三级分类
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list/tree")
    public Result list() {
        List<CategoryEntity> entities =categoryService.listWithTree();
        return Result.succ(entities);
    }
}
