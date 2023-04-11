package com.techelevator.services;

import com.techelevator.model.Course;
import org.springframework.web.client.RestTemplate;

public class RestMathFactsService implements mathFactsApi {

    private static final String API_URL = "http://numbersapi.com/random/math";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Course getMathFact() {
        Course course = restTemplate.getForObject(API_URL, Course.class);
        return course;
    }
}
