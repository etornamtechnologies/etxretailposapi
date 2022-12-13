package com.etx.engineering.PosService.domain.model;

import com.etx.engineering.PosService.domain.enums.EntityTypes;
import com.etx.engineering.PosService.domain.enums.SystemActivities;

import javax.persistence.*;

@Entity
@Table(name = "activity_logs")
public class ActivityLog extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductCategoryGen")
    @SequenceGenerator(
            name = "ProductCategoryGen",
            allocationSize = 1
    )
    private Long id;

    private String srcIp;

    private SystemActivities activity;
    private String data;
    private String url;
    private Long entityId;
    private EntityTypes entityType;
}
