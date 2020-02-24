package com.chsi.skeleton.service;

import java.io.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class S3ServiceTest {
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Autowired
    private Storage storage;

    @Test
    public void writeReadFile() {
        String key = "HELP.md";
        File expected = new File(key);
        storage.writeFile(bucketName, key, expected);
        File actual =  storage.readFile(bucketName, key);
        storage.deleteFile(bucketName, key);
        Assert.assertEquals(expected, actual);
    }
}