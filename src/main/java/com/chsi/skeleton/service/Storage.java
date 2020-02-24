package com.chsi.skeleton.service;

import java.io.*;

public interface Storage {
    File readFile(String bucketName, String key);
    void writeFile(String bucketName, String key, File file);
    void deleteFile(String bucketName, String key);
}
