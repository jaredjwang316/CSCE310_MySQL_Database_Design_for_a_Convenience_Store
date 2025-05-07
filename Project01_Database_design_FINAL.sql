-- DROP TABLE PAYMENT;
-- DROP TABLE ORDER_DETAIL;
-- DROP TABLE CUST_ORDER;
-- DROP TABLE CUSTOMER;
-- DROP TABLE PRODUCT;
-- DROP TABLE SUPPLIER;

-- ----------------------------------------------------------------
-- SUPPLIER 
-- ----------------------------------------------------------------

CREATE TABLE SUPPLIER (
    SupplierID       INT           PRIMARY KEY,
    SupplierName     VARCHAR(255),
    SupplierAddress  VARCHAR(255),
    SupplierPhone    VARCHAR(20)
);

-- ---------------------------------------------
-- Product Table:
--    Related to the Supplier
-- ---------------------------------------------
CREATE TABLE PRODUCT (
    ProductID INT PRIMARY KEY,
    SupplierID  INT,
    ProductName VARCHAR(255),
    RetailPrice DECIMAL(10, 2),
    FOREIGN KEY (SupplierID) REFERENCES SUPPLIER (SupplierID)
);

-- ----------------------------------------------
-- Customer Information
-- ---------------------------------------------
CREATE TABLE CUSTOMER (
    CustomerID    INT           PRIMARY KEY,
    CustomerName      VARCHAR(255),
    CustomerAddress   VARCHAR(300),
    CustomerPhone     VARCHAR(20)
);


-- ----------------------------------------------
-- CUST_ORDER Information
-- ----------------------------------------------

CREATE TABLE CUST_ORDER (
    OrderID        INT    PRIMARY KEY,
    CustomerID     INT,
    OrderDate      DATE,
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID)
);

-- ----------------------------------------------------------------------------
-- ORDER_DETAIL 
-- 

CREATE TABLE ORDER_DETAIL (
   OrderID      INT,
   ProductID    INT,
   Quantity     INT,
   PRIMARY KEY (OrderID, ProductID),
   FOREIGN KEY (OrderID)   REFERENCES CUST_ORDER( OrderID),
   FOREIGN KEY (ProductID) REFERENCES PRODUCT( ProductID)
);


-- ----------------------------------------------------------------------------
-- Payment information on each order
-- ----------------------------------------------------------------------------
CREATE TABLE PAYMENT (
  PayID         INT          PRIMARY KEY,
  CardNumber    VARCHAR(16),
  CardHolder    VARCHAR(255),
  ExpiryDate    DATE,
  CVV           VARCHAR(3),
  Amount        DECIMAL(10, 2),
  FOREIGN KEY (PayID) REFERENCES CUST_ORDER(OrderID)
);

-- =============================================================================================
-- Data Manipulation: Inserting Data for Testing
-- ---------------------------------------------------------------------------------------------
-- 1. Insert on Supplier
-- ------------------- 
INSERT INTO SUPPLIER VALUES
   (101, 'Glacier Purified Water', '3007 Main Street, Los Angeles, CA 20034', '321-405-1004'),
   (102, 'Kentuky Old Farm Ranch', '324 Homesick Dr., Louisville, KY 19898', '267-225-3459');


-- ------------------
-- 2. PRODUCT
-- 
INSERT INTO PRODUCT VALUES
       (11, 101, 'Glacier 16 oz Bottled Water - 6 pack', 1.99),
       (12, 101, 'Mountain Dew 8 oz Drink - 6 pack', 2.49),
       (13, 102, 'Midium Grade Egg - 12 pack', 1.49);

-- -------------------
-- 3. CUSTOMER 
-- 
INSERT INTO CUSTOMER VALUES
       (1001, 'John Doe',     '713-234-1768', '5401 Renwick, Apt.123, Houston, TX, 77071'),
       (1002, 'Sofia Clinton','832-722-9089', '4023 Rampart, Apt.203, Houston, TX, 77071'),
       (1003, 'Tony Vergas',  '979-843-8913', '719 Naple Street, College Station, TX, 77840');

-- ------------------
-- 4. CUST_ORDER 
--
INSERT INTO CUST_ORDER VALUES
   (10001, 1002, '2020-02-01 09:28'), 
   (10011, 1001, '2020-02-11 19:01'), 
   (10101, 1003, '2020-03-02 11:40'),
   (10201, 1001, '2020-04-27 09:56'); 

-- ------------------
-- 5. ORDER_DETAILS 
--
INSERT INTO ORDER_DETAIL (OrderID, ProductID, Quantity)
 VALUES
  (10001, 11, 2),
  (10001, 13, 3),
  (10011, 12, 5),
  (10101, 12, 2),
  (10101, 13, 2),
  (10201, 13, 8);

-- -----------------
-- 6. PAYMENT
-- -----------------
INSERT INTO PAYMENT
 VALUES
   (10001, '4147400412349876', 'Softia Clinton','2028-02-01','567',  5.88), 
   (10011, '3000500070009000', 'Joe Doe',       '2027-01-11','233', 19.12), 
   (10101, '2111322243335444', 'Tony Vargas',   '2026-03-02','908',  3.49),
   (10201, '3000500070009000', 'Joe Doe',       '2027-01-11','233',  4.78);
 
