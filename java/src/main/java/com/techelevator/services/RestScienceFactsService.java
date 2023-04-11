package com.techelevator.services;

import com.techelevator.model.Course;
import org.springframework.web.client.RestTemplate;

public class RestScienceFactsService implements scienceFactsApi {

    private static final String API_URL = "http://numbersapi.com/random/date";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Course getScienceFact() {
        Course course = restTemplate.getForObject(API_URL, Course.class);
        return course;
    }


}
