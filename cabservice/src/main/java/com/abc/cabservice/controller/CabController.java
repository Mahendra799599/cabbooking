package com.abc.cabservice.controller;
import com.abc.cabservice.entity.Cab;
import com.abc.cabservice.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    private CabService cabService;

    @GetMapping("/all")
    public ResponseEntity<List<Cab>> getAllCabs() {
        List<Cab> cabs = cabService.getAllCabs();
        return ResponseEntity.ok(cabs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cab> getCabById(@PathVariable int id) {
        Cab cab = cabService.getCabById(id);
        if (cab != null) {
            return ResponseEntity.ok(cab);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Cab> addCab(@RequestBody Cab cab) {
        Cab addedCab = cabService.addCab(cab);
        if (addedCab != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedCab);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cab> updateCab(@PathVariable int id, @RequestBody Cab cab) {
        Cab updatedCab = cabService.updateCab(id, cab);
        if (updatedCab != null) {
            return ResponseEntity.ok(updatedCab);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCab(@PathVariable int id) {
        cabService.deleteCab(id);
        return ResponseEntity.noContent().build();
    }
}
