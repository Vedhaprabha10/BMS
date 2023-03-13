package com.example.Bms.Service;

import com.example.Bms.Entity.Flat;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FlatService {
    Flat uploadFlat(Flat flat);
    List<Flat> getAll();
    List<Flat> bulkFlat(MultipartFile file) throws IOException;
}
