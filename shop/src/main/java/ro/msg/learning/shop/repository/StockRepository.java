package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.models.Stock;
import ro.msg.learning.shop.models.StockId;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockId> {

    //gaseste stockul care are cantitatea mai mare decat cea comandata pentru produs
    Stock findStockByProductIdAndQuantityGreaterThanEqualAndLocationId(Integer idProduct, Integer quantity, Integer idLocation);

    //stockul cu produsul ce are minim cantitatea cerura , lista cu stockuri ordonate descrescator
    List<Stock> findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(Integer idProduct, Integer quantity);

    Stock findByProductIdAndAndLocationId(Integer idProduct, Integer idLocation);
}
