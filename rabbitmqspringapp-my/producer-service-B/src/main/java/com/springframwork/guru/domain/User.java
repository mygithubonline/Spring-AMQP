package com.springframwork.guru.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = User.class)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    private String userId;
    private String userName;

    // public User(String userId, String userName) {
    //     this.userId = userId;
    //     this.userName = userName;
    // }

    // public User() {

    // }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

// let’s start by writing a User domain class whose objects we will exchange as messages.
// The User class implements the Serializable interface as it will be transmitted over a messaging system. 
// It is also annotated with the @Component annotation so that Spring treats it as a Spring-managed object.

// The @JsonIdentityInfo annotation indicates the object identity during 
// the serialization and deserialization process. This class also contains 
// two properties userId and userName, an empty constructor, getter and setter methods, 
// and an overridden toString() method.