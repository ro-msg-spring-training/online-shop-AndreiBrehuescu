package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.models.Supplier;

import java.util.List;
import java.util.Optional;

public interface ISupplier {

    List<SupplierDto> getAllSupplier();

    void addSupplier(SupplierDto supplierDto);

    Optional<SupplierDto> getSupplierById(Integer id);

    void deleteSupplierById(Integer id);

    void update(SupplierDto supplierDto);
}
