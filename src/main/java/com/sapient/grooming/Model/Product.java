package com.sapient.grooming.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private String id;
    private String name;
    private Boolean warranty;
    private Category category;
}
