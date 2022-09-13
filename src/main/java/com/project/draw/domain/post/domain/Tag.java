package com.project.draw.domain.post.domain;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum Tag {
    SPRING_BOOT("SpringBoot", ""),
    MYSQL("MySQL", ""),
    NODE_JS("Node.js", ""),
    FRONTEND("FrontEnd", ""),
    REACT("React", ""),
    VUE_JS("Vue.js", ""),
    SWIFT("Swift", ""),
    JAVA("Java", ""),
    JAVASCRIPT("JavaScript", "");

    private final String name;

    private final String image_url;

}