package com.leobarreto.desafiosenior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leobarreto.desafiosenior.models.Items;
import java.util.List;


public interface ItemRepository extends JpaRepository<Items, Long> {
    
    List<Items> findAll();

    Items findByIdItems(Long id);
}
