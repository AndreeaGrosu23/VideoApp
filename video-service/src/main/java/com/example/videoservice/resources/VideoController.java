package com.example.videoservice.resources;

import com.example.videoservice.models.*;
import com.example.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/video-service")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private RestTemplate restTemplate;

    public VideoController(VideoRepository videoRepository, RestTemplate restTemplate) {
        this.videoRepository = videoRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/videos")
    public List<Video> getAllMovies() {
        return videoRepository.findAll();
    }

    @GetMapping("/video/{videoId}")
    public VideoInfo getVideoInfo(@PathVariable("videoId") int videoId) {
        VideoRecommendationsList videoRecommendationsList = restTemplate.getForObject("http://video-recommendation-service/recommendation/"+videoId, VideoRecommendationsList.class);
        VideoInfo videoInfo = new VideoInfo();
        Video video = videoRepository.findById(videoId).orElse(null);
        videoInfo.setName(video.getName());
        videoInfo.setUrl(video.getUrl());
        videoInfo.setVideoRecommendationsList(videoRecommendationsList.getVideoRecommendationsList());
        return videoInfo;
    }

    @PostMapping("/add-recommendation/{videoId}")
    public void addRecommendation(@PathVariable("videoId") int videoId, @RequestBody RecommendationForm recommendationForm) {
        VideoRecommendation videoRecommendation = new VideoRecommendation(recommendationForm.getRating(), recommendationForm.getComment(), videoId);
        VideoRecommendation newVideoRecommendation = restTemplate.postForObject("http://video-recommendation-service/recommendation/add-recommendation/"+videoId, videoRecommendation, VideoRecommendation.class);
    }

}
