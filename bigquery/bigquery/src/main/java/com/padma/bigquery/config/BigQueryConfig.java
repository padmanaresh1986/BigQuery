package com.padma.bigquery.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;

public class BigQueryConfig {

    private String bigQueryFile = "path to your json key file";
    private String projectId = "your project id";

    @Bean
    public BigQuery bigQuery() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(bigQueryFile));
        return BigQueryOptions.newBuilder()
                .setCredentials(credentials)
                .setProjectId(projectId)
                .build().getService();

    }
}
