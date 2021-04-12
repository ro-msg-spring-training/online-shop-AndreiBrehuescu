package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.converter.BaseConvertor;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.models.Supplier;

public class SupplierConvertor extends BaseConvertor<Supplier, SupplierDto> {
    @Override
    public Supplier getModel(SupplierDto supplierDto) {
        Supplier supplier = Supplier.builder()
                                .name(supplierDto.getName())
                                .build();
        supplier.setId(supplierDto.getId());

        return supplier;
    }

    @Override
    public SupplierDto getDto(Supplier supplier) {
        return SupplierDto.builder()
                        .id(supplier.getId())
                        .name(supplier.getName())
                        .build();
    }
}
