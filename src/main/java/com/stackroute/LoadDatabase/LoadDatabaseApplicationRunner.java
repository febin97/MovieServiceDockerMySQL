package com.stackroute.LoadDatabase;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabaseApplicationRunner implements ApplicationRunner {
    private @Value("${valueId}") int valueId;
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
    private final MovieRepository movieRepository;

    public LoadDatabaseApplicationRunner(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        movieRepository.save(new Movie(valueId,valueImdb,valueBudget,valueLanguage,valueTitle,valuePosterPath,valueRevenue,
                valueRuntime,valueReleaseDate,valueOverview,valueTagline));

        //Using @Value Annotation

    }
}
