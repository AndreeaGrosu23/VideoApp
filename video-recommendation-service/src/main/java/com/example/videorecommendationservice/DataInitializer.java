package com.example.videorecommendationservice;

import com.example.videorecommendationservice.models.VideoRecommendation;
import com.example.videorecommendationservice.repository.VideoRecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final VideoRecommendationRepository videoRecommendationRepository;

    public DataInitializer(VideoRecommendationRepository videoRecommendationRepository) {
        this.videoRecommendationRepository = videoRecommendationRepository;
    }

    @Override
    public void run(String... args) {
        videoRecommendationRepository.save(VideoRecommendation.builder()
                .rating(5)
                .comment("Roadtrip music. I love it!")
                .videoId(1)
                .build());

        videoRecommendationRepository.save(VideoRecommendation.builder()
                .rating(5)
                .comment("Makes my cheerful")
                .videoId(1)
                .build());

        videoRecommendationRepository.save(VideoRecommendation.builder()
                .rating(4)
                .comment("I adore this australian band, mixed emotions, both happy and sad")
                .videoId(2)
                .build());

        videoRecommendationRepository.save(VideoRecommendation.builder()
                .rating(4)
                .comment("Let's go to Vama Veche!!!")
                .videoId(3)
                .build());

        videoRecommendationRepository.save(VideoRecommendation.builder()
                .rating(5)
                .comment("I can close my eyes and travel around the world with this music!")
                .videoId(2)
                .build());

        videoRecommendationRepository.save(VideoRecommendation.builder()
                .rating(5)
                .comment("Sets you nicely for the day, happy vibes")
                .videoId(3)
                .build());

        videoRecommendationRepository.save(VideoRecommendation.builder()
                .rating(4)
                .comment("Makes me miss home")
                .videoId(4)
                .build());
    }
}
