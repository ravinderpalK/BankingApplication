package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.UserAlreadyExistsException;
import com.bank.exception.UserNotFoundException;
import com.bank.model.User;
import com.bank.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User creteUser(User user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new UserAlreadyExistsException("user with username " + user.getUsername() + " already exists");
		}
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> 
			new UserNotFoundException("No such user present")
		);
	}

	@Override
	public User updateUser(Long id, User updatedUser) {
		User existingUser = userRepository.findById(id).orElseThrow(() ->
			new UserNotFoundException("No such user present")
		);
		existingUser.setFullName(updatedUser.getFullName());
		existingUser.setPhone(updatedUser.getPhone());
		existingUser.setEmail(updatedUser.getEmail());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id))  {
			throw new UserNotFoundException("No such user present");
		}
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
