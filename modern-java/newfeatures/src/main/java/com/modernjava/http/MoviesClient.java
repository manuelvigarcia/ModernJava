package com.modernjava.http;
/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;*/
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.net.http.HttpRequest.newBuilder;

public class MoviesClient {

    HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(2))
            .build();

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public static String ALL_MOVIES_URL =  "http://127.0.0.1:8000/newfeatures/src/main/resources/movies.json";
    public static String MOVIE_BY_ID_URL = "http://127.0.0.1:8000/newfeatures/src/main/resources/movie_by_id.json";


    public CompletableFuture<Movie> getMovieByIdAsync(){
        var request = requestBuilder(MOVIE_BY_ID_URL);
        try {
            var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            return response.thenApply(httpResponse -> {
                System.out.println("status code as: " + httpResponse.statusCode());
                try {
                    return objectMapper.readValue(httpResponse.body(), Movie.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Movie getMovieById(){
        var request = requestBuilder(MOVIE_BY_ID_URL);
        try {
            var response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code as: " + response.statusCode());
            return objectMapper.readValue(response.body(), Movie.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Movie> getAllMovies(){
        var request = requestBuilder(ALL_MOVIES_URL);
        try {
            var response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code as: " + response.statusCode());
            System.out.println("Response Body: \n" + response.body());
            return objectMapper.readValue(response.body(), new TypeReference<>() {});
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public static HttpRequest requestBuilder(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }
}
