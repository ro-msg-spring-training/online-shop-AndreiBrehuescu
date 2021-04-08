
create table if not exists `location`(
    `id` Integer not null AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(25),
    `addressCountry` varchar(20),
    `addressCity` varchar(20),
    `addressCounty` varchar(20),
    `addressStreetAddress` varchar(20)
    );