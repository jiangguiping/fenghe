package com.jiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiang.entity.CategoryEntity;

import java.util.List;

public interface CategoryService extends IService<CategoryEntity> {
    List<CategoryEntity> listWithTree();
}
