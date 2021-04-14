package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.models.OrderTable;

public interface OrderRepository extends JpaRepository<OrderTable, Integer> {
}
