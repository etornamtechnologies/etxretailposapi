package com.etx.engineering.PosService.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skus")
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductCategoryGen")
    @SequenceGenerator(
            name = "ProductCategoryGen",
            allocationSize = 1
    )
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(
            mappedBy = "sku",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ProductVariantSku> productVariants;


}
