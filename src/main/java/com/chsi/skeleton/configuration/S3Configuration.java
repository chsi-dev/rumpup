package com.chsi.skeleton.configuration;

import org.springframework.context.annotation.*;
import software.amazon.awssdk.regions.*;
import software.amazon.awssdk.services.s3.*;


@Configuration
public class
S3Configuration {
    @Bean(destroyMethod = "close")
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.EU_CENTRAL_1)
                .build();
    }
}
