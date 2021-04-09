package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.models.Stock;
import ro.msg.learning.shop.models.StockId;

public interface StockRepository extends JpaRepository<Stock, StockId> {
}