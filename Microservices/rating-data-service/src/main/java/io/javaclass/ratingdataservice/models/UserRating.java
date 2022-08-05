package io.javaclass.ratingdataservice.models;

import lombok.Data;

import java.util.List;

@Data
public class UserRating {

    private List<Rating> userrating;
}
