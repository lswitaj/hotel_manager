DROP TABLE Reservation IF EXISTS;

DROP TABLE Room IF EXISTS;

DROP TABLE Employee IF EXISTS;

DROP TABLE Client IF EXISTS;

CREATE TABLE Employee (
  PESEL VARCHAR(11) PRIMARY KEY,
  password VARCHAR(15),
  name VARCHAR(15),
  surname VARCHAR(15),
  position VARCHAR(15),
  phoneNumber VARCHAR(9),
  email VARCHAR(45),
  salary INTEGER DEFAULT 2000,
);

CREATE TABLE Client (
  login VARCHAR(15) PRIMARY KEY,
  password VARCHAR(15),
  name VARCHAR(15),
  surname VARCHAR(15),
  phoneNumber VARCHAR(9),
  email VARCHAR(45),
);

CREATE TABLE Room (
  roomNumber INTEGER PRIMARY KEY,
  size INTEGER DEFAULT 2,
  price INTEGER DEFAULT 300,
);

CREATE TABLE Reservation (
  reservationId INTEGER PRIMARY KEY,
  status VARCHAR(20),
  cost INTEGER,
  firstDay DATE,
  lastDay DATE,
  board BOOLEAN,
  Client_login VARCHAR(15) FOREIGN KEY REFERENCES Client(login),
  Room_roomNumber INTEGER FOREIGN KEY REFERENCES Room(roomNumber),
);