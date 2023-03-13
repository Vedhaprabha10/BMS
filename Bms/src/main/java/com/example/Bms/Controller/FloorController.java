package com.example.Bms.Controller;

import com.example.Bms.Entity.Floor;
import com.example.Bms.Service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/floor")
public class FloorController {
    @Autowired
    FloorService floorService;

    @PostMapping(value = "/add")
    public Floor upload(@RequestBody Floor floor) {
     return floorService.uploadFloor(floor);
    }
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        List<Floor> floor=floorService.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(floor);
    }
    @PostMapping("/bulkUpload")
    public List<Floor> bulkFloor(@RequestParam("file") MultipartFile file) throws IOException {
        List<Floor> floorList=floorService.bulkFloor(file);
        return floorList;
    }
}
