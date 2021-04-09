package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.models.Supplier;
import ro.msg.learning.shop.repository.SupplierRepository;
import ro.msg.learning.shop.service.interfaces.ISupplier;

import java.util.List;
import java.util.Optional;

public class SupplierServiceImplementation implements ISupplier {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSupplier() {
        return this.supplierRepository.findAll();
    }

    @Override
    public void addSupplier(Supplier supplier) {
        this.supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> getSupplierById(Integer id) {
        return this.supplierRepository.findById(id);
    }

    @Override
    public void deleteSupplierById(Integer id) {
        this.supplierRepository.deleteById(id);
    }
}
