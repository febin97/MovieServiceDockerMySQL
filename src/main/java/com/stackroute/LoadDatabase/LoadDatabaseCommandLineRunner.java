package com.stackroute.LoadDatabase;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabaseCommandLineRunner {
    @Bean
    public CommandLineRunner initDatabase(MovieRepository repository){
        return args -> {
            repository.save(new Movie(123,"IMDB id Spidey",234,"Language","Movie Title:Spidey","Movie Posterpath",
                                        1000,120,"12th September 2019","Movie Overview","Movie TagLine"));
            repository.save(new Movie(121,"IMDB id Iron Man",234,"Language","Movie Title:Spidey","Movie Posterpath",
                    1000,120,"12th September 2019","Movie Overview","Movie TagLine"));
            repository.save(new Movie(122,"IMDB id Iron Man",234,"Language","Movie Title:Spidey","Movie Posterpath",
                    1000,120,"12th September 2019","Movie Overview","Movie TagLine"));
        };
    }
}
