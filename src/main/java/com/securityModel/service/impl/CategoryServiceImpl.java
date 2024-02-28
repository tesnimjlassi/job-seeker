package com.securityModel.service.impl;

import com.securityModel.models.Category;
import com.securityModel.repository.CategoryRepository;
import com.securityModel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category
    createCategory(Category category){
        return categoryRepository.save(category);
    }
    @Override
    public List<Category>
    allCategories(){
        return   categoryRepository.findAll();
    }
    @Override
    public Category
    categoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(null);
    }
    @Override
    public Category
    updateCategory(Long id,Category category){
        Category cat=categoryRepository.findById(id).orElseThrow(null);
        if (cat!=null){
            category.setId(id);
            return categoryRepository.save(category);
        }else {
            throw new RuntimeException("Error!");
        }

    }
    @Override
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
