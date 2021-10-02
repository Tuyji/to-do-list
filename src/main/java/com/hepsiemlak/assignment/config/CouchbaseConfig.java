package com.hepsiemlak.assignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.connection.string}")
    private String connectionString;
    @Value("${couchbase.username}")
    private String username;
    @Value("${couchbase.password}")
    private String password;
    @Value("${couchbase.bucketname}")
    private String bucketName;


    @Override
    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }
}