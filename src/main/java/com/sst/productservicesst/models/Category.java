package com.sst.productservicesst.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Category {
    private Long id;
    private String title;
    private String description;
}
