CREATE DATABASE FLY_SKY;
USE FLY_SKY;

--Passenger Table--
CREATE TABLE PASSENGER(
CustomerId int IDENTITY(1001,1) PRIMARY KEY,
Name VARCHAR(50) NOT NULL,
Email VARCHAR(70) NOT NULL,
ContactNo VARCHAR(30) NOT NULL
);

--Rate Table--
USE FLY_SKY;
CREATE TABLE RATE(
AirlineName VARCHAR(50) NOT NULL,
EconomicClass INT NOT NULL,
BusinessClass INT NOT NULL
);

--Route Table--
USE FLY_SKY;
CREATE TABLE ROUTE(
Place VARCHAR(50),
PlaceID VARCHAR(40)
);

--Bill Table--
USE FLY_SKY;
CREATE TABLE BILL(
BillId INT Identity(5001,1) NOT NULL,
Amount Int NOT NULL,
Quantity Int NOT NULL
);

--  