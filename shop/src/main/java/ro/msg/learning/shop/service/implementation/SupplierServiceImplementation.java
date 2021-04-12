package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.SupplierConvertor;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.models.Product;
import ro.msg.learning.shop.models.Supplier;
import ro.msg.learning.shop.repository.SupplierRepository;
import ro.msg.learning.shop.service.interfaces.ISupplier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupplierServiceImplementation implements ISupplier {

    private final SupplierRepository supplierRepository;
    private final SupplierConvertor supplierConvertor;

    @Override
    public List<SupplierDto> getAllSupplier() {
        List<Supplier> supplierList= this.supplierRepository.findAll();

        Collection<SupplierDto> supplierDtoList = this.supplierConvertor.convertModelToDto(supplierList);

        return new ArrayList<>(supplierDtoList);
    }

    @Override
    public void addSupplier(SupplierDto supplierDto) {
        Supplier supplier = this.supplierConvertor.getModel(supplierDto);

        this.supplierRepository.save(supplier);
    }

    @Override
    public Optional<SupplierDto> getSupplierById(Integer id) {
        Optional<Supplier> supplier = this.supplierRepository.findById(id);

        Optional<SupplierDto> supplierDto = Optional.empty();

        if( supplier.isEmpty() ){
            return supplierDto;
        }

        SupplierDto supplierDtoObject = this.supplierConvertor.getDto(supplier.get());

        return Optional.of(supplierDtoObject);
    }

    @Override
    public void deleteSupplierById(Integer id) {

        Optional<Supplier> supplier = this.supplierRepository.findById(id);

        if(supplier.isEmpty()){
            return;
        }

        this.supplierRepository.deleteById(id);
    }

    @Override
    public void update(SupplierDto supplierDto) {
        Optional<Supplier> supplierModel = this.supplierRepository.findById(supplierDto.getId());

        if( supplierModel.isEmpty()){
            this.supplierRepository.save(this.supplierConvertor.getModel(supplierDto));
            return;
        }

        Supplier existingdSupplier = supplierModel.get();
        Supplier newSupplier = this.supplierConvertor.getModel(supplierDto);


        existingdSupplier.setName(newSupplier.getName());
        this.supplierRepository.save(existingdSupplier);
    }
}
