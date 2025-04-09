package com.bank.service;

import java.util.List;

import com.bank.model.User;
import com.bank.repository.UserRepository;

public interface UserService {
	
	public static final UserRepository userRepository = null;
	
	public User creteUser(User user);
	public User getUser(Long id);
	public User updateUser(Long id, User updatedUser);
	public void deleteUser(Long id);
	public List<User> getAllUsers();
}
