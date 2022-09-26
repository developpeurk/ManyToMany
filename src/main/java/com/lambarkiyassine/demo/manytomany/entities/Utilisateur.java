package com.lambarkiyassine.demo.manytomany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "utilisateurs", fetch = FetchType.EAGER)
    private Collection<Groupe> groupes = new ArrayList<>();
}
