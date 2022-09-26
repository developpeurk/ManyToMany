package com.lambarkiyassine.demo.manytomany.services;

import com.lambarkiyassine.demo.manytomany.entities.Groupe;
import com.lambarkiyassine.demo.manytomany.entities.Utilisateur;

public interface UserService {
    Utilisateur saveUser(Utilisateur utilisateur);
    Groupe saveGroupe(Groupe groupe);
    void addUserToGroup(String userName, String groupName);
    Utilisateur findByUserName(String userName);
}
