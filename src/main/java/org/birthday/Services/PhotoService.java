package org.birthday.Services;

import org.birthday.Model.Photo;
import org.birthday.Model.PhotoObject;
import org.birthday.Repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepo;


    // GET methods
    public List<Photo> getPhotoListByDay(int day) {
        List<Photo> result = photoRepo.findByDay(day);
        return result;
    }

    public Photo getPhotoById(String id) {
        Photo result = photoRepo.findById(id).get();
        return result;
    }

    // Add methods
    public String savePhoto(PhotoObject object) throws IOException {
        Photo photo = new Photo();
        photo.setTitle(object.getTitle());
        photo.setDescription(object.getDescription());
        photo.setDay(object.getDay());
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, object.getFile().getBytes()));

        photo = photoRepo.save(photo);

        return photo.getId();
    }

    // Delete methods
    public String deletePhotoById(String id) {
        photoRepo.deleteById(id);
        return "Deleted";
    }

}
