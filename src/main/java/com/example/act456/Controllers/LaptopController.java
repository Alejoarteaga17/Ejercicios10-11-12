package com.example.act456.Controllers;

import com.example.act456.Entity.Laptop;
import com.example.act456.Repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return repository.findAll();
    }
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOp = repository.findById(id);

        if(laptopOp.isPresent()){
            return ResponseEntity.ok(laptopOp.get());
        }else return ResponseEntity.notFound().build();
    }
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
       if(laptop.getID() != null){
           return ResponseEntity.badRequest().build();
       }
       Laptop result = repository.save(laptop);
       return ResponseEntity.ok(result);
    }
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getID() == null){
            return ResponseEntity.badRequest().build();
        }
        if(!repository.existsById(laptop.getID())){
            return ResponseEntity.notFound().build();
        }
        Laptop result = repository.save(laptop);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> deleteOne(Long id){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.notFound().build();

    }
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
