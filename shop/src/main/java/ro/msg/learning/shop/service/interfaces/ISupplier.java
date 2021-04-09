package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.models.Supplier;

import java.util.List;
import java.util.Optional;

public interface ISupplier {

    List<Supplier> getAllSupplier();

    void addSupplier(Supplier supplier);

    Optional<Supplier> getSupplierById(Integer id);

    void deleteSupplierById(Integer id);
}
