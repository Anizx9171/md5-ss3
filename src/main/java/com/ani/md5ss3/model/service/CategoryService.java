package com.ani.md5ss3.model.service;

import com.ani.md5ss3.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category saveOrUpdate(Category category);
    Category findById(Long id);
    void deleteById(Long id);
}
