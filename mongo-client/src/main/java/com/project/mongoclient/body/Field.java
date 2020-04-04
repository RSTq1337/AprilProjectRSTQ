package com.project.mongoclient.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Field {

    private String title;
    private String name;
    private String type;
    private Values values;
}
