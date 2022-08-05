package io.javaclass.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogItems {

    private String name;
    private String desc;
    private int rating;
}
