package com.jiang.service.impl;

import com.jiang.entity.CategoryEntity;
import com.jiang.entity.GoodsCategory;
import com.jiang.mapper.GoodsCategoryMapper;
import com.jiang.service.GoodsCategoryService;
import com.jiang.vo.IndexCategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jiang.common.CategoryLevelEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;


    @Override
    public List<IndexCategoryVO> getCategoriesForIndex() {

        List<IndexCategoryVO> reusle =goodsCategoryMapper.add();

        List<IndexCategoryVO> level1Menus = reusle.stream().filter((categoryEntity)->{
            return categoryEntity.getParentId() == 0;
        }).map((menu)->{
            menu.setChildren(getChildrens(menu,reusle));
            return menu;
        }).collect(Collectors.toList());//就收集成一个 list
        return level1Menus;
    }

    //递归查找所有菜单的子菜单
    private List<IndexCategoryVO> getChildrens(IndexCategoryVO root,List<IndexCategoryVO> all) {
        List<IndexCategoryVO> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentId() == root.getCategoryId();
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity,all));//这里使用递归查询第三级分类
            return categoryEntity;
        }).collect(Collectors.toList());

        return children;
    }
}
