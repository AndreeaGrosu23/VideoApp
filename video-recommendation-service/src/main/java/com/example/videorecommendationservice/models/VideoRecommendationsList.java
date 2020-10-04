package com.example.videorecommendationservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRecommendationsList {

    private List<VideoRecommendation> videoRecommendationsList;

}

