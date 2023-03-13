package com.example.Bms.Service;

import com.example.Bms.Entity.Floor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FloorService {
    Floor uploadFloor(Floor floor);
    List<Floor> getAll();
    List<Floor> bulkFloor(MultipartFile file) throws IOException;

}
