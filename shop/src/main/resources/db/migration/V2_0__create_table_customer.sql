

create table if not exists `customer`(
    `id` Integer not null AUTO_INCREMENT PRIMARY KEY,
    `firstname` varchar(50),
    `lastname` varchar(50),
    `username` varchar(50),
    `password` varchar(128),
    `emailaddress` varchar(50)
    );