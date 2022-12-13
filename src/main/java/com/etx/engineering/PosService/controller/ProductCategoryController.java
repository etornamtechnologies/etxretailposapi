package com.etx.engineering.PosService.controller;

import com.etx.engineering.PosService.domain.dto.RequestDTO;
import com.etx.engineering.PosService.domain.dto.ResponseDTO;
import com.etx.engineering.PosService.domain.model.ProductCategory;
import com.etx.engineering.PosService.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequestMapping("/api/v1/productCategories")
@AllArgsConstructor
@Slf4j
public class ProductCategoryController {
    private ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseDTO<List<ProductCategory>> getAll() {
        return new ResponseDTO<>(0, "Success", productCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseDTO<ProductCategory> getAll(@PathVariable(name = "id") Long prodCatId) {
        return new ResponseDTO<>(0, "Success", productCategoryService.findById(prodCatId));
    }


    @PostMapping
    public ResponseDTO<ProductCategory> save(@RequestBody @Valid RequestDTO.CreateProductCategoryRequestDTO payload,
                                             Principal principal) {
        return new ResponseDTO<>(0, "Product Category Created Successfully", productCategoryService.save(payload));
    }

    @PutMapping("/{id}")
    public ResponseDTO<ProductCategory> edit(@PathVariable(name = "id") Long prodCatId,
                                             @RequestBody @Valid RequestDTO.CreateProductCategoryRequestDTO payload,
                                             Principal principal) {
        return new ResponseDTO<>(0, "Product Category Updated Successfully", productCategoryService.update(prodCatId, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseDTO delete(@PathVariable(name = "id") Long prodCatId,
                              Principal principal) {
        productCategoryService.delete(prodCatId);
        return new ResponseDTO(0, "Product Category Deleted Successfully", null);
    }
}
