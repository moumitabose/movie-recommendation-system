package com.example.movie_recommendation.repository;

import com.example.movie_recommendation.model.Movie;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;


@Repository
public class MovieRepository {

    private final DynamoDbTable<Movie> movieTable;


    public MovieRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.movieTable =
                dynamoDbEnhancedClient.table("movies", TableSchema.fromBean(Movie.class));
    }


    public void save(Movie movie) {
        movieTable.putItem(movie);
    }

    public Optional<Movie> findById(String movie_id) {
        return Optional.ofNullable(movieTable.getItem(r -> r.key(k -> k.partitionValue(movie_id))));
    }

    public void delete(String movie_id) {
        movieTable.deleteItem(r -> r.key(k -> k.partitionValue(movie_id)));
    }

}
