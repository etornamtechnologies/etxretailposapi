package com.etx.engineering.PosService.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "depots")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductCategoryGen")
    @SequenceGenerator(
            name = "ProductCategoryGen",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private String location;

    private String address;

    private String phone;

    private String email;

    private String description;
}
