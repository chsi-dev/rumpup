package com.chsi.skeleton.service;

import com.chsi.skeleton.service.configuration.*;
import java.io.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@SpringBootTest
@ContextHierarchy(
        {
                @ContextConfiguration(classes = S3Configuration.class),
                @ContextConfiguration(classes = S3ServiceTestConfiguration.class)
        }
)
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
        File actual = storage.readFile(bucketName, key);
        storage.deleteFile(bucketName, key);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void writeReadFileBlankKeyException() {
        String key = "";
        File expected = new File(key);
        storage.writeFile(bucketName, key, expected);
        File actual = storage.readFile(bucketName, key);
        storage.deleteFile(bucketName, key);
        Assert.assertEquals(expected, actual);
    }
}