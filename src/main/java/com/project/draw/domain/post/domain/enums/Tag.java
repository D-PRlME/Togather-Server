package com.project.draw.domain.post.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
public enum Tag {
    SPRINGBOOT("SpringBoot", "https://wouldyou1214.s3.amazonaws.com/SPRING.png"),
    MYSQL("MySQL", "https://wouldyou1214.s3.amazonaws.com/MySQL.png"),
    NODE_JS("Node.js", "https://wouldyou1214.s3.amazonaws.com/Node.js.png"),
    BACKEND("BackEnd", "https://wouldyou1214.s3.amazonaws.com/BackEnd.png"),
    FRONTEND("FrontEnd", "https://wouldyou1214.s3.amazonaws.com/FrontEnd.png"),
    REACT("React", "https://wouldyou1214.s3.amazonaws.com/React.png"),
    VUE_JS("Vue.js", "https://wouldyou1214.s3.amazonaws.com/Vue.js.png"),
    SWIFT("Swift", "https://wouldyou1214.s3.amazonaws.com/Swift.png"),
    JAVA("Java", "https://wouldyou1214.s3.amazonaws.com/Java.png"),
    JAVASCRIPT("JavaScript", "https://wouldyou1214.s3.amazonaws.com/JavaScript.png");

    private final String name;

    private final String imageUrl;

}