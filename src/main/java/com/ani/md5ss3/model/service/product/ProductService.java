package com.ani.md5ss3.model.service.product;

import com.ani.md5ss3.model.entity.Category;
import com.ani.md5ss3.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product saveOrUpdate(Product category);
    Product findById(Long id);
    void deleteById(Long id);
}
