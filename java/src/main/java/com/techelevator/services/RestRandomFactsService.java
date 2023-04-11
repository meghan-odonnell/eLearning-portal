package com.techelevator.services;

import com.techelevator.model.Course;
import org.springframework.web.client.RestTemplate;

public class RestRandomFactsService implements randomFactsApi {

    private static final String API_URL = "http://numbersapi.com/random/trivia";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Course getRandomFact() {
        Course course = restTemplate.getForObject(API_URL, Course.class);
        return course;
    }
}

