package com.example.Bms.ServiceImpl;

import com.example.Bms.Entity.Flat;
import com.example.Bms.Helper.FlatHelper;
import com.example.Bms.Repository.FlatRepo;
import com.example.Bms.Service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FlatServiceImpl implements FlatService {

    @Autowired
    FlatRepo flatRepo;

    @Override
    public Flat uploadFlat(Flat flat) {
        return flatRepo.save(flat);
    }

    @Override
    public List<Flat> getAll() {
        return flatRepo.findAll();
    }

    @Override
    public List<Flat> bulkFlat(MultipartFile file) throws IOException {
        List<Flat> flatList = FlatHelper.convertExcelToListOfEntity(file.getInputStream());
        flatRepo.saveAll(flatList);
        return flatList;
    }
}