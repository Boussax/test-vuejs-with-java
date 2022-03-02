package com.bbtutorials.users.service;

import java.io.Console;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.UsersRepository;

@Component
public class UsersService {
	
	private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    
    public Users saveUser(Users users) throws Exception {
        if (users.firstName.equals("") || users.lastName.equals("") || users.email.equals("")) {
            throw new Exception("must fill all fields");
        }
    	else {
            return usersRepository.save(users);
        }
    }
        
    public Users updateUser(Users users) throws Exception {
        if (users.firstName.equals("") || users.lastName.equals("") || users.email.equals("")) {
            throw new Exception("must fill all fields");
        }
    	else {
            return usersRepository.save(users);
        }
    }
    
    public void deleteUserById(Integer id) {
        System.out.println("in deleteUser method");
    	usersRepository.deleteById(id);
    }

}
