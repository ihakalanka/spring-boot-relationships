package com.akalanka.oneToOne;

import com.akalanka.oneToOne.entity.Gender;
import com.akalanka.oneToOne.entity.User;
import com.akalanka.oneToOne.entity.UserProfile;
import com.akalanka.oneToOne.repository.UserProfileRepository;
import com.akalanka.oneToOne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Akalanka");
		user.setEmail("ss@gmail.com");

		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Colombo");
		userProfile.setDob(LocalDate.of(1995, 10, 10));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhone("0771234567");

		user.setUserProfile(userProfile);
		userProfile.setUser(user);

		userRepository.save(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

}
