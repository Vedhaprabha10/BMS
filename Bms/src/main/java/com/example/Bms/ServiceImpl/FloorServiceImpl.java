package com.example.Bms.ServiceImpl;

import com.example.Bms.Entity.Floor;
import com.example.Bms.Helper.FloorHelper;
import com.example.Bms.Repository.FloorRepo;
import com.example.Bms.Service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    FloorRepo floorRepo;

    @Override
    public Floor uploadFloor(Floor floor) {
    return floorRepo.save(floor);
    }

    @Override
    public List<Floor> getAll() {
        return floorRepo.findAll();
    }

    @Override
    public List<Floor> bulkFloor(MultipartFile file) throws IOException {
        List<Floor> floorList = FloorHelper.convertExcelToListOfEntity(file.getInputStream());
        floorRepo.saveAll(floorList);
        return floorList;
    }

}
