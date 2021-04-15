package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.models.Stock;
import ro.msg.learning.shop.models.StockId;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockId> {

    Stock findStockByProductIdAndQuantityGreaterThanEqualAndLocationId(Integer idProduct, Integer quantity, Integer idLocation);

    List<Stock> findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(Integer idProduct, Integer quantity);

}
