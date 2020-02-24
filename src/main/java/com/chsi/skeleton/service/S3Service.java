package com.chsi.skeleton.service;

import java.io.*;
import java.util.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import software.amazon.awssdk.core.*;
import software.amazon.awssdk.core.sync.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

@Service
public class S3Service implements Storage{
    private static final Logger logger = LoggerFactory.getLogger(S3Service.class);

    private S3Client s3Client;

    @Autowired
    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public File readFile(String bucketName, String key) {
        File file = new File(key);
        ResponseInputStream in = s3Client.getObject(GetObjectRequest
                .builder()
                .bucket(bucketName)
                .key(key)
                .build());
        if( in != null) {
            try {
            FileCopyUtils.copy(in, new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return file;
    }

    @Override
    public void writeFile(String bucketName, String key, File file) {
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
        s3Client.deleteObject(DeleteObjectRequest
                .builder()
                .bucket(bucketName)
                .key(key)
                .build());
    }
}
