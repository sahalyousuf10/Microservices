package io.javaclass.movieinfoservice.resources;

import io.javaclass.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class Movieresource {

    @RequestMapping("{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        return new Movie(movieId, "Test Name");
    }
}
