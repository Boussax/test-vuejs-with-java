package com.bbtutorials.users.links;

import org.springframework.stereotype.Component;

@Component
public class UserLinks {
	
	public static final String LIST_USERS = "/users";
    public static final String ADD_USER = "/user";
    public static final String UPDATE_USER = "/user/{user.id}";
    public static final String DELETE_BY_ID = "/user/{user.id}";

}
