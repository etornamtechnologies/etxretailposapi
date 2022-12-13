package com.etx.engineering.PosService.service;

import com.etx.engineering.PosService.domain.dto.RequestDTO;
import com.etx.engineering.PosService.domain.exceptions.DatabaseException;
import com.etx.engineering.PosService.domain.exceptions.NotFoundException;
import com.etx.engineering.PosService.domain.model.ProductCategory;
import com.etx.engineering.PosService.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll() {
        try {
            return productCategoryRepository.findAll();
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }


    public ProductCategory findById(Long id) {
        try {
            return productCategoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Product Category not found"));
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }

    public ProductCategory save(RequestDTO.CreateProductCategoryRequestDTO payload) {
        ProductCategory model = new ProductCategory();
        model.setName(payload.getName());
        model.setDescription(payload.getDescription());
        model.setProductType(payload.getProductType());
        try {

            return productCategoryRepository.save(model);
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }


    public ProductCategory update(Long id, RequestDTO.CreateProductCategoryRequestDTO payload) {
        ProductCategory model = findById(id);
        model.setName(payload.getName());
        model.setDescription(payload.getDescription());
        try {

            return productCategoryRepository.save(model);
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }


    public void delete(Long id) {
        try {
            ProductCategory productCategory = findById(id);
            productCategoryRepository.delete(productCategory);
        } catch (Exception e) {
            throw new DatabaseException("Failed to delete product category");
        }
    }
}
