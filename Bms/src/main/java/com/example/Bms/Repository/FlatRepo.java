package com.example.Bms.Repository;

import com.example.Bms.Entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepo extends JpaRepository<Flat,Integer> {
}
