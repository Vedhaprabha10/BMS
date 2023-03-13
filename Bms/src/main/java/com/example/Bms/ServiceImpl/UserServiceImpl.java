package com.example.Bms.ServiceImpl;

import com.example.Bms.Entity.User;
import com.example.Bms.Helper.UserHelper;
import com.example.Bms.Repository.UserRepo;
import com.example.Bms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public User uploadUser(User user) {
    return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public List<User> blukUser(MultipartFile file) throws IOException {
        List<User> floorList = UserHelper.convertExcelToListOfEntity(file.getInputStream());
        userRepo.saveAll(floorList);
        return floorList;
    }

    @Override
    public List<User> findByPhone(Long phone) {
        List<User> phone1=userRepo.findByPhone(phone);
        return phone1;
    }

    @Override
    public User update(User user) {
        User user1 = new User();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        user1.setPhone(user.getPhone());
        return user1;
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> getById(Integer id) {
       Optional<User> byId =userRepo.findById(id);
        return byId;
    }

}

