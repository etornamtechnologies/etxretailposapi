package com.etx.engineering.PosService.service;

import com.etx.engineering.PosService.domain.dto.RequestDTO;
import com.etx.engineering.PosService.domain.model.ProductCategory;

import java.util.List;

public interface CRUDServiceInterface<T, E> {
    public E findAll();
    public T findById(Long id);
    public T save(Object payload);
    public T update(Long id, Object payload);

    ProductCategory save(RequestDTO.CreateProductCategoryRequestDTO payload);

    ProductCategory update(Long id, RequestDTO.CreateProductCategoryRequestDTO payload);

    public void delete();
}
