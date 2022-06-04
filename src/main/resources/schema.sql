create table if not exists Ingredient (
 id INT PRIMARY KEY,
 name varchar(35) not null,
 type varchar(10) not null
);
create table if not exists Taco (
 id INT PRIMARY KEY auto_increment,
 name varchar(50) not null,
 created_at timestamp not null
);
create table if not exists Taco_Ingredients (
 taco_entity_id INT not null,
 ingredients_id INT not null
);
alter table Taco_Ingredients
 add foreign key (taco_entity_id) references Taco(id);
alter table Taco_Ingredients
 add foreign key (ingredients_id) references Ingredient(id);
create table if not exists Taco_Order (
 id INT not null PRIMARY KEY,
 deliveryName varchar(50) not null,
 deliveryStreet varchar(50) not null,
 deliveryCity varchar(50) not null,
 deliveryState varchar(2) not null,
 deliveryZip varchar(10) not null,
 ccNumber varchar(16) not null,
 ccExpiration varchar(5) not null,
 ccCVV varchar(3) not null,
 placedAt timestamp not null
);
create table if not exists Taco_Order_Tacos (
 tacoOrder INT not null,
 taco_id INT not null
);
alter table Taco_Order_Tacos
 add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
 add foreign key (taco_id) references Taco(id);