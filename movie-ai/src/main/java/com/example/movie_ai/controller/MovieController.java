package com.example.movie_ai.controller;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;



import java.util.List;


import com.example.movie_ai.model.Movie;
import com.example.movie_ai.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping()
    public Movie addMovie(@RequestBody Movie movie) {

        try {
            Client client = new Client();
            String query = "Write a brief description of the movie: " + movie.getTitle();

            GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", query, null);
            String aiResponse = response.text();

            if (aiResponse == null || aiResponse.isEmpty()) {
                aiResponse = "Description not available";
            }
            movie.setDescription(aiResponse);
            System.out.println("Description: " + movie.getDescription());


            System.out.println("Generated Description: " + aiResponse);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return movieRepository.save(movie);
    }
//    @GetMapping("/allmovies")
//    public List<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }

//    @DeleteMapping("/movie/${id}")
//    public void deleteMovie(@PathVariable int id) {
//        movieRepository.deleteById(id);
//    }


}
