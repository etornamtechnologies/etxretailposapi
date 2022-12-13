package com.etx.engineering.PosService.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
public class Product extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductCategoryGen")
    @SequenceGenerator(
            name = "ProductCategoryGen",
            allocationSize = 1
    )
    private Long id;
    private String name;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    private Set<ProductVariant> productVariants;

}
