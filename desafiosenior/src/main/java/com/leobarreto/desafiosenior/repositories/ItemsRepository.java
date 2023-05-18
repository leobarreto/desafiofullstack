package com.leobarreto.desafiosenior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leobarreto.desafiosenior.models.Items;
import java.util.List;
import java.util.Optional;


public interface ItemsRepository extends JpaRepository<Items, Long> {
    
    List<Items> findAll();

    Optional<Items> findById(Long id);
}
