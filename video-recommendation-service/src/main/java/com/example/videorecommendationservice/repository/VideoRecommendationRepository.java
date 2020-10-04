package com.example.videorecommendationservice.repository;

import com.example.videorecommendationservice.models.VideoRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRecommendationRepository extends JpaRepository<VideoRecommendation, Integer> {

    List<VideoRecommendation> findAllByVideoId(int videoId);
}
