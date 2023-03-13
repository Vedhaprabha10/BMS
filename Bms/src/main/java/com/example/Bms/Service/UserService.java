package com.example.Bms.Service;

import com.example.Bms.Entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User uploadUser(User user);
    List<User> getAllUser();
    List<User> blukUser(MultipartFile file) throws IOException;
    List<User> findByPhone(Long phone);
    User update(User user);
    void deleteById (Integer id);
    Optional<User> getById(Integer id);
}
