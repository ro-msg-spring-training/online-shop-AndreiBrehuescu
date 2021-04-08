
create table if not exists `stock`(
    `idProduct` Integer,
    `idLocation` Integer,
    `quantity` Integer,
    CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY (`idProduct`) references PRODUCT(ID),
    CONSTRAINT FK_STOCK_LOCATION FOREIGN KEY (`idLocation`) references LOCATION(ID)
    );