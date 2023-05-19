package com.leobarreto.desafiosenior.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leobarreto.desafiosenior.models.Items;
import com.leobarreto.desafiosenior.services.ItemsServices;

@RestController
@RequestMapping("/item")
public class ItemsController {
    
    @Autowired
    private ItemsServices itemsServices;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public ResponseEntity<List<Items>> findAll() {
        List<Items> obj = this.itemsServices.findAll();

        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<Items> findById(@PathVariable Long id) {
        Items obj = this.itemsServices.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Items obj) {
        this.itemsServices.create(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Items obj, @PathVariable Long id) {
        obj.setId(id);
        this.itemsServices.update(obj);

        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.itemsServices.delete(id);

        return ResponseEntity.noContent().build();
    }
}
