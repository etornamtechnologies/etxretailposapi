package com.etx.engineering.PosService.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "product_variants_sku")
public class ProductVariantSku extends Auditable<String>{
    @EmbeddedId
    private ProductVariantSkuId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productVariantId")
    private ProductVariant productVariant;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("skuId")
    private Sku sku;

    @Column(name = "price", columnDefinition = "INTEGER DEFAULT 0")
    private Integer price;

    private Boolean isAvailable;

}
