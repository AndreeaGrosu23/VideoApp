package com.example.videoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRecommendation {
//    private int id;
    private int rating;
    private String comment;
    private int videoId;
}
