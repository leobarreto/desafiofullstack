package com.leobarreto.desafiosenior.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leobarreto.desafiosenior.models.Items;
import com.leobarreto.desafiosenior.repositories.ItemRepository;

@Service
public class ItemServices {
    
    @Autowired
    private ItemRepository itemRepository;

    public Items findById(Long id) {
        Optional<Items> item = this.itemRepository.findById(id);

        return item.orElseThrow(() -> new RuntimeException("Item" + Items.class.getName() + "não encontrado."));
    }

    @Transactional
    public Items create(Items obj) {
        obj.setId(null);
        obj = this.itemRepository.save(obj);
        return obj;
    }

    @Transactional
    public Items update(Items obj) {
        Items newObj = findById(obj.getId());

        return this.itemRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        this.itemRepository.deleteById(id);
    }
}
