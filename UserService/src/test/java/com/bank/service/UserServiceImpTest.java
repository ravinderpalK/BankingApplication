package com.bank.service;

import com.bank.exception.UserAlreadyExistsException;
import com.bank.exception.UserNotFoundException;
import com.bank.model.User;
import com.bank.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j; // ✅ Added for logging

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@Slf4j 
@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpTest.class);
	
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImp userService;

	private User user;

	@BeforeEach
	void setUp() {
		user = new User();
		user.setUserId(1L);
		user.setUsername("john_doe");
		user.setFullName("John Doe");
		user.setEmail("john@example.com");
		user.setPhone("1234567890");
	}

	@Test
	void createUser_WhenUserNotExists_ShouldReturnSavedUser() {
		when(userRepository.findByUsername("john_doe")).thenReturn(Optional.empty());
		when(userRepository.save(user)).thenReturn(user);

		User createdUser = userService.creteUser(user);

		log.info("Created User: {}", createdUser.getUsername());
		assertNotNull(createdUser);
		assertEquals("john_doe", createdUser.getUsername());
		verify(userRepository).save(user);
	}

	@Test
	void createUser_WhenUserExists_ShouldThrowException() {
		when(userRepository.findByUsername("john_doe")).thenReturn(Optional.of(user));

		assertThrows(UserAlreadyExistsException.class, () -> userService.creteUser(user));
		log.info("User already exists - Exception thrown successfully.");
		verify(userRepository, never()).save(any(User.class));
	}

	@Test
	void getUser_WhenUserExists_ShouldReturnUser() {
		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		User found = userService.getUser(1L);

		log.info("Found User: {}", found.getUsername());
		assertNotNull(found);
		assertEquals(1L, found.getUserId());
	}

	@Test
	void getUser_WhenUserDoesNotExist_ShouldThrowException() {
		when(userRepository.findById(1L)).thenReturn(Optional.empty());

		assertThrows(UserNotFoundException.class, () -> userService.getUser(1L));
		log.info("User not found - Exception thrown successfully.");
	}

	@Test
	void updateUser_WhenUserExists_ShouldUpdateAndReturnUser() {
		User updatedInfo = new User();
		updatedInfo.setFullName("Jane Doe");
		updatedInfo.setPhone("9876543210");
		updatedInfo.setEmail("jane@example.com");

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		when(userRepository.save(any(User.class))).thenReturn(user);

		User updated = userService.updateUser(1L, updatedInfo);

		log.info("Updated User: {}, {}", updated.getFullName(), updated.getPhone());
		assertEquals("Jane Doe", updated.getFullName());
		assertEquals("9876543210", updated.getPhone());
		assertEquals("jane@example.com", updated.getEmail());
	}

	@Test
	void updateUser_WhenUserDoesNotExist_ShouldThrowException() {
		when(userRepository.findById(1L)).thenReturn(Optional.empty());

		assertThrows(UserNotFoundException.class, () -> userService.updateUser(1L, user));
		log.info("User not found for update - Exception thrown successfully.");
	}

	@Test
	void deleteUser_WhenUserExists_ShouldDeleteUser() {
		when(userRepository.existsById(1L)).thenReturn(true);
		doNothing().when(userRepository).deleteById(1L);

		userService.deleteUser(1L);

		log.info("User deleted successfully.");
		verify(userRepository).deleteById(1L);
	}

	@Test
	void deleteUser_WhenUserDoesNotExist_ShouldThrowException() {
		when(userRepository.existsById(1L)).thenReturn(false);

		assertThrows(UserNotFoundException.class, () -> userService.deleteUser(1L));
		log.info("User not found for deletion - Exception thrown successfully.");
	}

	@Test
	void getAllUsers_ShouldReturnUserList() {
		List<User> userList = Arrays.asList(user, user);
		when(userRepository.findAll()).thenReturn(userList);

		List<User> result = userService.getAllUsers();

		log.info("Total Users Retrieved: {}", result.size());
		assertEquals(2, result.size());
		verify(userRepository).findAll();
	}
}
