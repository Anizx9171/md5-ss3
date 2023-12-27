package com.ani.md5ss3.controller;

import com.ani.md5ss3.model.entity.Category;
import com.ani.md5ss3.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public String goCategoryPage(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "category/Index";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }
    @PostMapping("/add")
    public String createCategory(@ModelAttribute("category") Category category) {
        if (categoryService.saveOrUpdate(category) != null) {
            return "redirect:/category";
        }
        return "redirect:/add";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@ModelAttribute("category") Category category) {
        if (categoryService.saveOrUpdate(category) != null) {
            return "redirect:/category";
        }
        return "redirect:/edit";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return "redirect:/category";
    }
}
