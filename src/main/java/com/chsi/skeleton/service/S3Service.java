package com.chsi.skeleton.service;

import java.io.*;
import java.util.Optional;
import java.util.*;
import java.util.function.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import software.amazon.awssdk.core.*;
import software.amazon.awssdk.core.sync.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

@Service
public class S3Service implements Storage{
    private static final Logger logger = LoggerFactory.getLogger(S3Service.class);

    final private S3Client s3Client;

    @Autowired
    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public File readFile(String bucketName, String key) {
        return readFile(bucketName, key, this::validateStringList);
    }

    public File readFile(String bucketName, String key, BiConsumer<String, String> validator) {
        validator.accept(bucketName, key);
        File file = new File(key);
        Optional<ResponseInputStream<GetObjectResponse>> in = Optional.ofNullable(
                s3Client.getObject(GetObjectRequest
                        .builder()
                        .bucket(bucketName)
                        .key(key)
                        .build())
        );
        in.ifPresent((stream) -> {
            try {
                FileCopyUtils.copy(stream, new FileOutputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return file;
    }

    @Override
    public void writeFile(String bucketName, String key, File file) {
        writeFile(bucketName, key, file, this::validateStringList, f -> {
            if(Objects.isNull(f)) throw new RuntimeException();
        } );
    }

    public void writeFile(String bucketName, String key, File file, BiConsumer<String, String> validator, Consumer<File> fileValidator) {
        validator.accept(bucketName, key);
        fileValidator.accept(file);
        s3Client.putObject(
                PutObjectRequest
                        .builder()
                        .bucket(bucketName)
                        .key(key)
                        .build(),
                RequestBody.fromFile(file));
    }

    @Override
    public void deleteFile(String bucketName, String key) {
        deleteFile(bucketName, key, this::validateStringList);
    }

    public void deleteFile(String bucketName, String key, BiConsumer<String, String> validator) {
        validator.accept(bucketName, key);
        s3Client.deleteObject(DeleteObjectRequest
                .builder()
                .bucket(bucketName)
                .key(key)
                .build());
    }

    private void validateStringList(String ...s) {
        var result = Arrays.stream(s)
                .filter(String::isBlank)
                .count();
        if(result != 0) throw new RuntimeException();
    }
}
