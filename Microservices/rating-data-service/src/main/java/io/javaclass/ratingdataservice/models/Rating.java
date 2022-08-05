package io.javaclass.ratingdataservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Rating {

    private String movieId;
    private int rating;

}
