package com.developersuraj.OTutorBot.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionAnswerPOJo {

    public List<Candidate> candidates;

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
        public List<Part> parts;
        public String role;
    }

    @Getter
    @Setter
    public static class Part{
        public String text;
    }

}
