package com.bbtutorials.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
public class Users {
	
	@Id
	@Column
    public Integer id;

    @Column
    @NotNull(message="{NotNull.User.firstName}")
    public String firstName;
    
    @Column
    @NotNull(message="{NotNull.User.lastName}")
    public String lastName;
    
    @Column
    @NotNull(message="{NotNull.User.email}")
    public String email;

    

}
