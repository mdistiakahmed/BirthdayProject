package org.birthday.Model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@org.springframework.data.mongodb.core.mapping.Document(collection = "people")
public class Information {
    private ObjectId id;
    private String name;
    private boolean isTrue;
}
