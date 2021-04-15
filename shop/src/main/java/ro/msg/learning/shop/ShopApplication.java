package ro.msg.learning.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456789"));
		SpringApplication.run(ShopApplication.class, args);

	}

}
