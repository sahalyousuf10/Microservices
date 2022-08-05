package io.javaclass.moviecatalogservice.resource;

import com.netflix.discovery.DiscoveryClient;
import io.javaclass.moviecatalogservice.model.CatalogItems;
import io.javaclass.moviecatalogservice.model.Movie;
import io.javaclass.moviecatalogservice.model.Rating;
import io.javaclass.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItems> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+ userId, UserRating.class);

        return ratings.getUserrating().stream().map(rating -> {

                    // for each movie id call movie info service and get details

        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

            /*
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
             */
                    // put them all together

                    return new CatalogItems(movie.getName(), "Discription", rating.getRating());
        })
                .collect(Collectors.toList());

        //get all rated movie id

    }
}
