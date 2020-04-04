package com.project.mongoclient.body;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Values {
    private String none;
    private String v1;
    private String v2;
    private String v3;

}
