package com.technext.spring.resilience4j.registration.management.entity;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(
        value = "Seller",
        allowUserKeys = true
)
@HashIndex(fields = { "emailId" })
public class Seller implements Serializable {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String emailId;
    private List<Item> itemsSold;

}
