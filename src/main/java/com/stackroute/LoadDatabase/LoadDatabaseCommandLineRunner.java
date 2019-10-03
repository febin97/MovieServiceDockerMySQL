package com.stackroute.LoadDatabase;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:propertysource.properties")
public class LoadDatabaseCommandLineRunner {
    private @Value("${valueId3}") int valueId;
    private @Value("${valueImdb}") String valueImdb;
    private @Value("${valueBudget}") int valueBudget;
    private @Value("${valueLanguage}") String valueLanguage;
    private @Value("${valueTitle}") String valueTitle;
    private @Value("${valuePosterPath}") String valuePosterPath;
    private @Value("${valueRevenue}") int valueRevenue;
    private @Value("${valueRuntime}") int valueRuntime;
    private @Value("${valueReleaseDate}") String valueReleaseDate;
    private @Value("${valueOverview}") String valueOverview;
    private @Value("${valueTagLine}") String valueTagline;

    @Autowired
    private Environment env;

    @Bean
    public CommandLineRunner initDatabase(MovieRepository repository){
        return args -> {
            repository.save(new Movie(valueId,"IMDB id Spidey",234,"Language","Movie Title:Spidey","Movie Posterpath",
                    1000,120,"12th September 2019","Movie Overview","Movie TagLine"));

            repository.save(new Movie(Integer.parseInt(env.getProperty("valueId2")),
                    env.getProperty("valueImdb"),
                    Integer.parseInt(env.getProperty("valueBudget")),
                    env.getProperty("valueLanguage"),
                    env.getProperty("valueTitle"),
                    env.getProperty("valuePosterPath"),
                    Integer.parseInt(env.getProperty("valueRevenue")),
                    Integer.parseInt(env.getProperty("valueRuntime")),
                    env.getProperty("valueReleaseDate"),
                    env.getProperty("valueOverview"),
                    env.getProperty("valueTagLine")));
        };
    }
}
