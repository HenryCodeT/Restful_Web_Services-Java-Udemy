package com.rest.webservices01.restfullwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDAOService service;

    public UserResource(UserDAOService service){
        this.service = service;
    }

    //GEt /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //GEt /users
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id){
        User user = service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("ID:"+id);
        return user;
    }

    //POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }
}
