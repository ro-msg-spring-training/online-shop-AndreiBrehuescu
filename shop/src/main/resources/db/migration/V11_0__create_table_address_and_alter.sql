
create table if not exists `address`(
     `id` INTEGER not null AUTO_INCREMENT PRIMARY KEY ,
    `addressCountry` varchar(50),
    `addressCity` varchar(50),
    `addressCounty` varchar(50),
    `addressStreetAddress` varchar(50)
);


ALTER TABLE `location`
DROP COLUMN `addressCountry`, `addressCity`, `addressCounty`, `addressStreetAddress`;
ALTER TABLE `location`
ADD COLUMN `address` Integer;
ALTER TABLE `location`
ADD FOREIGN KEY (`address`) REFERENCES address(id);

ALTER TABLE `order`
DROP COLUMN `addressCountry`, `addressCity`, `addressCounty`, `addressStreetAddress`;
ALTER TABLE `order`
ADD COLUMN `address` Integer;
ALTER TABLE `order`
ADD FOREIGN KEY (`address`) REFERENCES address(id);