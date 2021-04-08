
create table if not exists `revenue`(
    `id` Integer not null AUTO_INCREMENT PRIMARY KEY,
    `idLocation` Integer,
    `date` TIMESTAMP,
    `sum` DECIMAL,
    CONSTRAINT FK_REVENUE_LOCATION FOREIGN KEY (`idLocation`) references LOCATION(ID)
    );