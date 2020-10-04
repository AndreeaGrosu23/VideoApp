package com.example.videoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoInfo {
    private String name;
    private String url;
    private List<VideoRecommendation> videoRecommendationsList;
}
