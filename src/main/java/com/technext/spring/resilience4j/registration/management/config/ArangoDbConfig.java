package com.technext.spring.resilience4j.registration.management.config;


import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@EnableArangoRepositories(
        basePackages = {"com.technext.spring.resilience4j.registration.management.repositories"})
public class ArangoDbConfig implements ArangoConfiguration {

    @Value("${arango.db.hostname}")
    private String arangoDbHostName;

    @Value("${arango.db.port}")
    private int arangoDbPort;

    @Value("${arango.db.user.id}")
    private String arangoDbUserId;

    @Value("${arango.db.user.key}")
    private String arangoDbUserKey;

    @Value("${arango.db.name}")
    private String arangoDbName;

    @Override
    //@Bean("arango")
    public Builder arango() {
        log.info("Try to connect ArangoDB with " +
                "dbName:{}"+
                "port:{}," +
                "user:{}," +
                "key:{}," +
                "hostname:{}",arangoDbHostName,arangoDbPort,arangoDbUserId,arangoDbUserKey,arangoDbName);
        return new ArangoDB.Builder()
                //.useProtocol(Protocol.HTTP_JSON)
                .host(arangoDbHostName, arangoDbPort)
                .user(arangoDbUserId)
                .password(arangoDbUserKey);
    }

    @Override
    public String database() {
        // Name of the database to be used
        return arangoDbName;
    }
}