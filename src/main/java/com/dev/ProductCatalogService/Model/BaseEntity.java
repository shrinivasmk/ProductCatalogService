package com.dev.ProductCatalogService.Model;

import com.dev.ProductCatalogService.enums.State;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {
    private int id;
    private Date createdDate;
    private Date modifiedDate;
    private State state;
}
