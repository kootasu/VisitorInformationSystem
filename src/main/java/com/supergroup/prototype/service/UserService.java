package com.supergroup.prototype.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supergroup.prototype.model.User;
import com.supergroup.prototype.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> listAll() {		
		return repo.findAll();
	}
	
	public void save(User product) {
		repo.save(product);
	}
	
	public User get(String userName) {
		return repo.findById(userName).get();
	}
	
	public void delete(String userName) {
		repo.deleteById(userName);
	}

}
