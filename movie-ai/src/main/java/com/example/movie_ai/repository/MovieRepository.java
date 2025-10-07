package com.example.movie_ai.repository;

import com.example.movie_ai.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository <Movie, Integer> {
}

// inherits CRUD create, read, update, delete
// save(), findById(), findAll(), delete()
// bridges gap btw app and database