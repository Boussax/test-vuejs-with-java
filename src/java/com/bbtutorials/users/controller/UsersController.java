package com.bbtutorials.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.links.UserLinks;
import com.bbtutorials.users.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() {
        log.info("UsersController:  list users");
        List<Users> resource = usersService.getUsers();
        return ResponseEntity.ok(resource);
    }
	
	@PostMapping(path = UserLinks.ADD_USER)
	public ResponseEntity<?> saveUser(@RequestBody Users user) {
        log.info("UsersController:  list users");
        Users resource = null;
        try{
             resource = usersService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(resource);
    }

    @PutMapping(path = UserLinks.UPDATE_USER)
	public ResponseEntity<?> updateUser(@RequestBody Users user) {
        log.info("UsersController:  list users");
        Users resource = null;
        try{
             resource = usersService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(resource);
    }
    	
	@DeleteMapping(path = UserLinks.DELETE_BY_ID)
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        log.info("UsersController:  list users");
        try {
            usersService.deleteUserById(id);;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("success");
    }
}
