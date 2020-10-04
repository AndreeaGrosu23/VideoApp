package com.example.videoservice;

import com.example.videoservice.models.Video;
import com.example.videoservice.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final VideoRepository videoRepository;

    public DataInitializer(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public void run(String... args) {
        videoRepository.save(Video.builder()
            .name("Iggy Pop - Wild Child")
            .url("https://www.youtube.com/embed/def3ob2h-1s")
            .build());

        videoRepository.save(Video.builder()
            .name("Angus and Julia Stone - Chateau")
            .url("https://www.youtube.com/embed/N9_5_Ee2sUs")
            .build());

        videoRepository.save(Video.builder()
            .name("Byron - Cu capul in nori")
            .url("https://www.youtube.com/embed/tLhjo-ahDb0")
            .build());

        videoRepository.save(Video.builder()
            .name("Robin and the Backstabbers - Sat dupa sat")
            .url("https://www.youtube.com/embed/VSSN9nv5sxo")
            .build());

    }
}
