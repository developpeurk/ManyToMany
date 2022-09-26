package com.lambarkiyassine.demo.manytomany.services;

import com.lambarkiyassine.demo.manytomany.entities.Groupe;
import com.lambarkiyassine.demo.manytomany.entities.Utilisateur;
import com.lambarkiyassine.demo.manytomany.repositories.GroupeRepository;
import com.lambarkiyassine.demo.manytomany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupeRepository groupeRepository;

    @Override
    public Utilisateur saveUser(Utilisateur utilisateur) {
        return userRepository.save(utilisateur);
    }

    @Override
    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public void addUserToGroup(String userName, String groupName) {
        Groupe groupe = groupeRepository.findByGroupeName(groupName);
        Utilisateur utilisateur = userRepository.findByUserName(userName);
        groupe.getUtilisateurs().add(utilisateur);

    }

    @Override
    public Utilisateur findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
