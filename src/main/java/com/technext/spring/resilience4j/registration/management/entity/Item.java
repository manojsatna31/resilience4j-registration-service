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


@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(
        value = "Item",
        allowUserKeys = true
)
//@HashIndex(fields = { "name","category" }, unique = true)
@HashIndex(fields = { "name","category" })
public class Item implements Serializable {

    private static final long serialVersionUID = -2034702689029067276L;
    @Id
    private String id;
    private String name;
    private String category;
    private double price;//per item
}
