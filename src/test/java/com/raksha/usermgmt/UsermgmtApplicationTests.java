package com.raksha.usermgmt;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.raksha.usermgmt.model.User;
import com.raksha.usermgmt.repository.UserRepository;
import com.raksha.usermgmt.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermgmtApplicationTests {

	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@Test
	public void retrieveAllUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User(7,"Raksha","Bhat","Developer"),new User(8,"Rekha","Bhat","Scientist")).collect(Collectors.toList()));
		assertEquals(2,service.getAllUsers().size());
	}
	
	@Test
	public void saveUserTest() {
		User user = new User(10, "Ravi","Sharma", "lawyer");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}
	
	@Test
	public void retrieveUserById() {
		int id = 9;
		Optional<User> user = Optional.of(new User(id,"Rashmi","Hegde","Surgeon"));
		when(repository.findById(id)).thenReturn(user);
		assertEquals(user.get(),service.findOne(id));
	}
	
	@Test
	public void getUsersByFirstName() {
		String firstName = "Raksha";
		when(repository.findByFirstName(firstName)).thenReturn(Stream.of(new User(7,"Raksha","Bhat","Developer")).collect(Collectors.toList()));
		assertEquals(1,service.getUsersByFirstName(firstName).size());
	}
	
	@Test
	public void deleteUser() {
		User user = new User(15,"Malthi","Hegde","Police");
		service.deleteUser(user);
		verify(repository,times(1)).delete(user);
	}

}
