package com.example.videorecommendationservice.resource;


import com.example.videorecommendationservice.models.VideoRecommendation;
import com.example.videorecommendationservice.models.VideoRecommendationsList;
import com.example.videorecommendationservice.repository.VideoRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class VideoRecommendationController {

    @Autowired
    private VideoRecommendationRepository videoRecommendationRepository;

    public VideoRecommendationController(VideoRecommendationRepository videoRecommendationRepository) {
        this.videoRecommendationRepository = videoRecommendationRepository;
    }

    @GetMapping("/{videoId}")
    public VideoRecommendationsList getAllRecommendationsByVideoId(@PathVariable("videoId") int videoId) {
        List<VideoRecommendation> recommendationList = videoRecommendationRepository.findAllByVideoId(videoId);
        return new VideoRecommendationsList(recommendationList);
    }

    @PostMapping("/add-recommendation/{videoId}")
    public void addRecommedation(@RequestBody VideoRecommendation videoRecommendation) {
        videoRecommendationRepository.save(videoRecommendation);
    }

}
