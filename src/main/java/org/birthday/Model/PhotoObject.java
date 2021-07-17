package org.birthday.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PhotoObject {
    private String id;
    private String title;
    private String description;
    private int day;
    MultipartFile file;
}
