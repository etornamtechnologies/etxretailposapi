package com.etx.engineering.PosService.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DiscountGen")
    @SequenceGenerator(
            name = "DiscountGen",
            allocationSize = 1
    )
    private Long id;

    private String name;
    private String description;
    private Integer discountFactor;
}
