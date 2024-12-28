package com.developersuraj.OTutorBot.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class QuestionPOJO {

    private String topic;
    private List<Question> questions;

    @Getter
    @Setter
    public static class Question {
        private String text;
        private List<String> choices;
    }
}
