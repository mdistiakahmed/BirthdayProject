package org.birthday.Model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "photos")
public class Photo {
    @Id
    private String id;
    private String title;
    private String description;
    private int day;
    private Binary image;
}
