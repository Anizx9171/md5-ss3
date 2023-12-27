package com.ani.md5ss3.controller;

import com.ani.md5ss3.model.entity.Product;
import com.ani.md5ss3.model.service.CategoryService;
import com.ani.md5ss3.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/product")
    public String goProductPage(Model model) {
        model.addAttribute("product", productService.findAll());
        return "product/Index";
    }

    @GetMapping("/add-pro")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "product/add";
    }
    @PostMapping("/add-pro")
    public String createProduct(@ModelAttribute("product") Product product) {
        if (productService.saveOrUpdate(product) != null) {
            return "redirect:/product";
        }
        return "redirect:/add";
    }

    @PostMapping("/edit-pro/{id}")
    public String updateProduct(@ModelAttribute("product") Product product) {
        if (productService.saveOrUpdate(product) != null) {
            return "redirect:/product";
        }
        return "redirect:/edit";
    }

    @GetMapping("/edit-pro/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @GetMapping("/delete-pro/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }
}
