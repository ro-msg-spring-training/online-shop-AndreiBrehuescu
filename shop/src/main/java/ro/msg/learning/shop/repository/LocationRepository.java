package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
