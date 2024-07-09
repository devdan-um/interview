package com.univer.interview.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Builder;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;

@Service
public class S3Service {

    S3Client client;
    S3Configuration config;

    void uploadFile(){
        /*config = S3Configuration.builder()
                .pathStyleAccessEnabled(true)
                .build();

        client = S3Client.builder().serviceConfiguration(config)
                .credentialsProvider(getCredentials())
                .region(Region.AWS_GLOBAL)
                .endpointOverride(URI.create(""))
                .build();*/

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new AWSCredentials() {
                    @Override
                    public String getAWSAccessKeyId() {
                        return "";
                    }

                    @Override
                    public String getAWSSecretKey() {
                        return "";
                    }
                }))
                .withRegion(Regions.DEFAULT_REGION)
                .build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket("univer_bucket")
                .key("")
                .build();

        s3Client.putObject("","", new File(""));

    }

    AwsCredentialsProvider getCredentials(){
        AwsCredentialsProvider awsCredentialsProvider = new AwsCredentialsProvider() {
            @Override
            public AwsCredentials resolveCredentials() {
                return new AwsCredentials() {
                    @Override
                    public String accessKeyId() {
                        return "";
                    }

                    @Override
                    public String secretAccessKey() {
                        return "";
                    }
                };
            }
        };
        return awsCredentialsProvider;
    }

}
