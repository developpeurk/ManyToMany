package com.lambarkiyassine.demo.manytomany.repositories;

import com.lambarkiyassine.demo.manytomany.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUserName(String userName);
}
