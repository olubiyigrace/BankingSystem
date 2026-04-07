package com.grolfbank;

import com.grolfbank.nextofkin.dto.NextOfKinRequestDto;
import com.grolfbank.users.dto.UserRequestDto;
import com.grolfbank.users.dto.UserResponseDto;
import com.grolfbank.users.mapper.UserMapper;
import com.grolfbank.users.repository.UserRepository;
import com.grolfbank.users.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({UserServiceImpl.class, UserMapper.class})
@DisplayName("h2 database test")
class BankingSystemApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userServiceImpl;

	private UserRequestDto userRequestDto;

	@BeforeEach
	void setUp() {
		// clean DB before each test
		userRepository.deleteAll();

		NextOfKinRequestDto nextOfKinRequestDto = new NextOfKinRequestDto();
		nextOfKinRequestDto.setFullName("Olubiyi Esther");
		nextOfKinRequestDto.setRelationship("Sister");

		userRequestDto = new UserRequestDto();
		userRequestDto.setEmail("grace@gmail.com");
		userRequestDto.setFullName("Olubiyi Grace Oluwafunke");
		userRequestDto.setNextOfKinRequestDto(nextOfKinRequestDto);
	}

	@Test
	@DisplayName("should create a new user")
	void shouldCreateANewUser() {
		UserResponseDto userResponse = userServiceImpl.createUser(userRequestDto);

		assertNotNull(userResponse);
		assertNotNull(userResponse.getId());
		assertEquals("Olubiyi Grace Oluwafunke", userResponse.getFullName());
		assertEquals("grace@gmail.com", userResponse.getEmail());
		assertEquals(1, userRepository.count());
		assertTrue(userRepository.existsByEmail("grace@gmail.com"));
	}

	@Test
	@DisplayName("should throw an exception if email already exists")
	void shouldThrowAnExceptionIfEmailExists() {
		userServiceImpl.createUser(userRequestDto);

		RuntimeException exception = assertThrows(RuntimeException.class,
				() -> userServiceImpl.createUser(userRequestDto));
		assertTrue(exception.getMessage().toLowerCase().contains("already"));
		assertEquals(1, userRepository.count());
	}

	@Test
	@DisplayName("should return a single user")
	void shouldReturnASingleUser() {
		UserResponseDto savedUser = userServiceImpl.createUser(userRequestDto);
		UserResponseDto userResponse = userServiceImpl.getSingleUser(savedUser.getId());

		assertNotNull(userResponse);
		assertEquals(savedUser.getId(), userResponse.getId());
		assertEquals(1, userRepository.count());
	}
}