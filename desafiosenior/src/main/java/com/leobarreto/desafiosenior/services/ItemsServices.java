package com.leobarreto.desafiosenior.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leobarreto.desafiosenior.models.Items;
import com.leobarreto.desafiosenior.repositories.ItemsRepository;

@Service
public class ItemsServices {
    
    @Autowired
    private ItemsRepository itemsRepository;

    public List<Items> findAll() {
        List<Items> item = this.itemsRepository.findAll();

        return item;
    }

    public Items findById(Long id) {
        Optional<Items> item = this.itemsRepository.findById(id);

        return item.orElseThrow(() -> new RuntimeException("Item" + Items.class.getName() + "não encontrado."));
    }

    @Transactional
    public Items create(Items obj) {
        obj.setId(null);
        obj = this.itemsRepository.save(obj);
        return obj;
    }

    @Transactional
    public Items update(Items obj) {

        return this.itemsRepository.save(obj);
    }

    @Transactional
    public void delete(Long id) {
        this.itemsRepository.deleteById(id);
    }
}
