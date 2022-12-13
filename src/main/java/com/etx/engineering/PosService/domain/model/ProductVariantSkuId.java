package com.etx.engineering.PosService.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantSkuId implements Serializable {
    @Column(name = "product_variant_id")
    private Long productVariantId;

    @Column(name = "sku_id")
    private long skuId;

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        ProductVariantSkuId that = (ProductVariantSkuId) obj;

        return Objects.equals(productVariantId, that.productVariantId) &&
                Objects.equals(skuId, that.skuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productVariantId, skuId);
    }
}
