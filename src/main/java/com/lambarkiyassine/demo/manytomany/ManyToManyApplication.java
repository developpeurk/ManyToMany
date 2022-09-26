package com.lambarkiyassine.demo.manytomany;

import com.lambarkiyassine.demo.manytomany.entities.Groupe;
import com.lambarkiyassine.demo.manytomany.entities.Utilisateur;
import com.lambarkiyassine.demo.manytomany.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

    private final UserServiceImpl userService;

    public ManyToManyApplication(UserServiceImpl userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.saveUser(new Utilisateur(null,"usr1","password",null));
        userService.saveUser(new Utilisateur(null,"admin","password2",null));
        userService.saveGroupe(new Groupe(null,"USER",null));
        userService.saveGroupe(new Groupe(null,"ADMIN",null));
        userService.addUserToGroup("user1","USER");
        userService.addUserToGroup("admin","USER");
        userService.addUserToGroup("admin","ADMIN");

        Utilisateur utilisateur =  userService.findByUserName("admin");
        System.out.println("Username: " + utilisateur.getUserName());
        System.out.println("Password: " + utilisateur.getPassword());
        System.out.println("Groupes: ");
        utilisateur.getGroupes().forEach(g->{
            System.out.println("Groupe: " + g.getGroupeName());
        });

    }
}
