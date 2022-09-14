package com.project.draw.domain.post.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Tag {
    SPRINGBOOT("SpringBoot", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    MYSQL("MySQL", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    NODE_JS("Node.js", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    BACKEND("BackEnd", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    FRONTEND("FrontEnd", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    REACT("React", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    VUE_JS("Vue.js", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    SWIFT("Swift", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    JAVA("Java", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png"),
    JAVASCRIPT("JavaScript", "https://myawsbucketswg1214.s3.amazonaws.com/myawsbucketswg1214/tmpimg.png");

    private final String name;

    private final String imageUrl;

}