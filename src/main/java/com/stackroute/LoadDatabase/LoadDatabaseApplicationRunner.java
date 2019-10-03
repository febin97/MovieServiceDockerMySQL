package com.stackroute.LoadDatabase;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabaseApplicationRunner implements ApplicationRunner {
    @Autowired
    private final MovieRepository movieRepository;

    public LoadDatabaseApplicationRunner(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieRepository.save(new Movie(245,"IMDB id IronMan",234,"Language","Movie Title:Spidey","Movie Posterpath",
                1000,120,"12th September 2019","Movie Overview","Movie TagLine"));

    }
}
