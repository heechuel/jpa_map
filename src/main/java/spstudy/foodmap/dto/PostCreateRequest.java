package spstudy.foodmap.dto;

import lombok.Getter;

@Getter
public class PostCreateRequest {
    private Long userId;

    private int rate;

    private String comment;

    private String place;

    private String street;

    private String zipCode;
}
