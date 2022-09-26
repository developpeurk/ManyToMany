package com.lambarkiyassine.demo.manytomany.repositories;

import com.lambarkiyassine.demo.manytomany.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    Groupe findByGroupeName(String groupeName);
}
