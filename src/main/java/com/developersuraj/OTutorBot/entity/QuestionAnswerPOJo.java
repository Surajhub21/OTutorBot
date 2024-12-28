package com.developersuraj.OTutorBot.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class QuestionAnswerPOJo {

    public ArrayList<Candidate> candidates;

    @Getter
    @Setter
    public static class Candidate{
        public Content content;
        public String finishReason;
        public double avgLogprobs;
    }

    @Getter
    @Setter
    public static class Content{
        public ArrayList<Part> parts;
        public String role;
    }

    @Getter
    @Setter
    public static class Part{
        public String text;
    }

}
