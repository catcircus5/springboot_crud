package com.example.BOOK;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Book")
public class Book {
    @Id
    private ObjectId id;

    @JsonProperty("name")
    private String bookName;

    @JsonProperty("author")
    private String authorName;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }
}
