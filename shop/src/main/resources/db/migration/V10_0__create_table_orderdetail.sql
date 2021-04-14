

create table if not exists `orderdetail`(
    `idOrder` INTEGER,
    `idProduct` INTEGER,
    `quantity` INTEGER,
    CONSTRAINT FK_ORDERDETAIL_PRODUCT FOREIGN KEY(`idProduct`) references "PRODUCT"(ID),
    CONSTRAINT FK_ORDERDETAIL_ORDER FOREIGN KEY (`idOrder`) references "ORDERTABLE"(ID)
    );