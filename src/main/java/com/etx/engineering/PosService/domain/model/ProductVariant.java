package com.etx.engineering.PosService.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_variants")
public class ProductVariant extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductVariantGen")
    @SequenceGenerator(
            name = "ProductVariantGen",
            allocationSize = 1
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String label;

    @Column(nullable = false, unique = true)
    private String uniqueDescription;
    @Column(nullable = true)
    private String barcode;
    private String description;
    private String imgUrl;

    private String color;

    private String size;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @OneToMany(
            mappedBy = "productVariant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ProductVariantSku> skus;
}
