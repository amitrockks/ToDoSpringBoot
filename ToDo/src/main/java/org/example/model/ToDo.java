package org.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tasks")
public class ToDo {
    @Id
    private Integer id;
    private String title;
    private boolean status;
}