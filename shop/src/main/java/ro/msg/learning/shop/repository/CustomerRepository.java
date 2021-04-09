package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
