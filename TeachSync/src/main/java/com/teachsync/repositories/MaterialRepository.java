package com.teachsync.repositories;


import com.teachsync.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Material findAllById(Long id);
}
