
create table if not exists `ordertable`(
    `id` Integer not null AUTO_INCREMENT PRIMARY KEY,
    `idLocation` Integer,
    `idCustomer` Integer,
    `createdAt` TIMESTAMP,
    `addressCountry` varchar(20),
    `addressCity` varchar(20),
    `addressCounty` varchar(20),
    `addressStreetAddress` varchar(20),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (`idCustomer`) references CUSTOMER(ID),
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY (`idLocation`) references LOCATION(ID)
    );