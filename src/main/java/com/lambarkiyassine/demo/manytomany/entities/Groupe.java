package com.lambarkiyassine.demo.manytomany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Groupe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String groupeName;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Utilisateur> utilisateurs = new ArrayList<>();


}
