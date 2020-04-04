package com.project.mongoclient.body;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class Info {
    @Id
    private String title;
    private String image;
    private List<Field> fields;

}
