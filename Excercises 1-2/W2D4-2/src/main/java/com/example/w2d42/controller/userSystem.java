package com.example.w2d42.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class userSystem {

    ArrayList<ourUsers> users = new ArrayList<>();

    @GetMapping("/users")
    public ArrayList<ourUsers> getAllUsers(){
        return users;
    }

    @PostMapping("/users")
    public String addUsers(@RequestBody ourUsers name){
        users.add(name);
        return "User added";
    }

    @PutMapping("/users/{index}")
    public String updateUsers(@RequestBody ourUsers name, @PathVariable int index){
        users.set(index, name);
        return "user updated";
    }

    @DeleteMapping("/users/{index}")
    public String removeUsers(@PathVariable int index){
        users.remove(index);
        return "user removed";
    }

}
