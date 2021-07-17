package org.birthday.controller;

import org.birthday.Model.Information;
import org.birthday.Model.Photo;
import org.birthday.Model.PhotoObject;
import org.birthday.Repository.InformationRepository;
import org.birthday.Repository.PhotoRepository;
import org.birthday.Services.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoRepository photoRepo;

    Logger log = LoggerFactory.getLogger(HomeController.class);


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        log.info("start test method");
        return ResponseEntity.ok("Birthday Server is running ok !!!");
    }

    @PostMapping("addInfo")
    public String saveBook(@RequestBody Information information){
        informationRepository.save(information);
        return "Added information : " + information.getId();
    }

    @GetMapping("/getAllInfo")
    public List<Information> getAllInformation(){
        return informationRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInformation(@PathVariable int id){
        informationRepository.deleteById(id);
        return "book deleted with id : "+ id;
    }

    // photos ----------------%%-------------------- photos

    @PostMapping("/photos/addPhoto")
    public String addPhoto(@ModelAttribute PhotoObject photoObject)
            throws IOException {
        String id = photoService.savePhoto(photoObject);
        return "redirect:/photos/" + id;
    }

    @GetMapping("/photos/getAllPhoto")
    public List<Photo> getPhotoList(@RequestParam("day") int day)
            throws IOException {
        List<Photo>result = photoService.getPhotoListByDay(day);
        return result;
    }

    @RequestMapping(value="/photos/getById", method = RequestMethod.GET)
    public Photo getById(@RequestParam("id") String id){
        int a=12;
        return photoService.getPhotoById(id);
    }

    @GetMapping("/photos/updatePhoto")
    public String updatePhoto(@ModelAttribute PhotoObject photoObject)
            throws IOException {
        String response = photoService.savePhoto(photoObject);
        return response;
    }

    @RequestMapping(value="/photos/delete", method = RequestMethod.DELETE)
    public String deletePhoto(@RequestParam("id") String id){
        int a=12;
        photoService.deletePhotoById(id);
        return "book deleted with id : "+ id;
    }
}
