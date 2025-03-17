package com.example.movie_recommendation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


@Configuration
@PropertySource("classpath:application.properties")
public class AwsConfig {










    @Bean
    public DynamoDbClient dynamoDbClient() {

        AwsCredentials credentials = DefaultCredentialsProvider.create().resolveCredentials();
        System.out.println("AWS Access Key: " + credentials.accessKeyId());
        System.out.println("AWS Secret Key: " + credentials.secretAccessKey());

        return DynamoDbClient.builder()
                .region(Region.US_EAST_2) // Use your desired region
                .credentialsProvider(DefaultCredentialsProvider.create()) // Use default credentials provider
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }


  }







