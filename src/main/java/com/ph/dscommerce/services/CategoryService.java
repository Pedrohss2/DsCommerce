package com.ph.dscommerce.services;

import com.ph.dscommerce.domain.entity.Category;
import com.ph.dscommerce.domain.repository.CategoryRepository;
import com.ph.dscommerce.rest.dto.CategoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        category = categoryRepository.save(category);
        return new CategoryDTO(category);
    }

}
