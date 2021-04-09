
create table if not exists `product`(
    `id` Integer not null AUTO_INCREMENT PRIMARY KEY ,
    `name` varchar(50),
    `description` varchar(50),
    `price` DECIMAL,
    `weight` DOUBLE PRECISION,
    `idProductCategory` Integer,
    `idSupplier` Integer,
    `imageUrl` varchar(256),
    CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (`idProductCategory`) references PRODUCTCATEGORY(ID),
    CONSTRAINT FK_PRODUCT_SUPPLIER FOREIGN KEY (`idSupplier`) references SUPPLIER(ID)
    );