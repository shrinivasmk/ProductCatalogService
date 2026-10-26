package com.dev.ProductCatalogService.Model;

import com.dev.ProductCatalogService.enums.State;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {
    private Long id;
    private Date createdDate;
    private Date modifiedDate;
    private State state;
}
