package com.example.act456.Repository;

import com.example.act456.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
