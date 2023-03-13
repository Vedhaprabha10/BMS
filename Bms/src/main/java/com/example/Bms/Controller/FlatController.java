package com.example.Bms.Controller;

import com.example.Bms.Entity.Flat;
import com.example.Bms.Service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/flat")
public class FlatController {
    @Autowired
    FlatService flatService;
    @PostMapping("/addFlat")
    public Flat uploadFlat(@RequestBody Flat flat) {
           return flatService.uploadFlat(flat);
    }
    @GetMapping("/getAllFalt")
    public List<Flat> getAll(){
        return flatService.getAll();
    }
    @PostMapping("/bulkFlat")
    public List<Flat> bulkUpload(@RequestParam("file")MultipartFile file) throws IOException {
        List<Flat> flatList=flatService.bulkFlat(file);
        return flatList;
    }
}
