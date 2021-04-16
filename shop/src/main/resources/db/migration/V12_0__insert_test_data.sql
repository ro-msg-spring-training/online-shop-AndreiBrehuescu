

INSERT INTO CUSTOMER(firstname, lastname, username, password, emailaddress)
VALUES ( 'Andrei', 'Brehuescu', 'andre123', '$2a$10$SG8i6dwjNdRHYbiYo0fpI.FT/reWNsdPs7pwjr6PNS9CxipDaZGFW', 'andrei@gmail.com' ),
       ('Dani' , 'Moc', 'danimoc123', 'abcdefgh', 'danidani@gmail.com'),
       ('gabriel', 'tomas', 'tomas123', 'tomasg', 'gabrTomas@gmail.con');

INSERT INTO SUPPLIER(NAME)
VALUES ( 'ChioSupplier' ),
       ( 'ColaSupplier' ),
       ( 'FruitSupplier');

insert into PRODUCTCATEGORY(name, description)
VALUES ( 'Chips', 'Chipsuri de cartofi' ),
       ( 'Racoritoare', 'Cola botanica'),
       ( 'Fructe', 'Fructe si legume');


insert into PRODUCT(name, description, price, weight, idproductcategory, idsupplier, imageurl)
VALUES ( 'ChioChips', 'CHipsuri', '10.5', '0.5', '1', '1', 'url_chioChips' ),
       ( 'PopCola', 'Cola racoritoare', '5.5', '0.2', '2', '2', 'url_popCOla'),
       ( 'Mere', 'fructe si legume', '3.5', '1.0', '3', '3', 'imgUrl_mere');



insert into ADDRESS(addresscountry, addresscity, addresscounty, addressstreetaddress)
VALUES ( 'Romania', 'Cluj-Napoca', 'Cluj', 'str1' ),
       ( 'Romania', 'BucurestiS2', 'Bucuresti', 'str3'),
       ( 'Romania', 'Constanta', 'Constanta', 'str5'),
       ( 'Romania', 'Alba Iulia', 'Alba', 'st6'),
       ( 'Romania', 'Brasov', 'Brasov', 'str8');


insert into LOCATION(name, address)
values ('ColaAndChipsDeposit', 1),
       ('ColaDepositAndChips', 2),
       ('FruitDeposit', 3);

insert into STOCK(idproduct, idlocation, quantity)
VALUES ( '1', '1', '100' ),
       ( '1', '2', '150'),
       ( '2', '1', '125'),
       ( '2', '2', '65'),
       ( '3', '3', '80');