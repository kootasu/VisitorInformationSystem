package com.supergroup.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supergroup.prototype.model.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
