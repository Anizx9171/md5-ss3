package com.ani.md5ss3.model.reponsitory;

import com.ani.md5ss3.model.entity.Category;
import com.ani.md5ss3.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
