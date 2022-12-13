package com.etx.engineering.PosService.domain.model;

import com.etx.engineering.PosService.domain.enums.ProductType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_categories")
@Data
public class ProductCategory extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductCategoryGen")
    @SequenceGenerator(
            name = "ProductCategoryGen",
            allocationSize = 1
    )
    private Long id;

    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private String description;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;
}
