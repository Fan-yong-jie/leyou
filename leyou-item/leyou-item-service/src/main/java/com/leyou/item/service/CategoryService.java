package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public List<Category> queryCategoryListByPid(Long pid){
        Category category = new Category();
        category.setParentId(pid);

        return categoryMapper.select(category);
    }
    public List<String> queryNamesByIds(List<Long> ids){
        List<Category> list = categoryMapper.selectByIdList(ids);
        ArrayList<String> names = new ArrayList<>();
        for (Category category:list){
            names.add(category.getName());
        }
        return names;
    }
}
