-- =============================================
-- Kich ban tao Database QLBANHANG
-- Bai thuc hanh Quan ly Ban hang
-- =============================================

USE master;
GO

-- Kich hoat tai khoan sa va dat mat khau dong bo voi DBConnection.java
ALTER LOGIN sa WITH PASSWORD = 'concavang@123';
ALTER LOGIN sa ENABLE;
GO

-- Bat che do xac thuc Mixed Mode (SQL Server and Windows Authentication)
EXEC xp_instance_regwrite N'HKEY_LOCAL_MACHINE', N'Software\Microsoft\MSSQLServer\MSSQLServer', N'LoginMode', REG_DWORD, 2;
GO

-- Xoa database neu da ton tai de tao moi hoan chinh
IF EXISTS (SELECT name FROM sys.databases WHERE name = N'QLBANHANG')
BEGIN
    ALTER DATABASE QLBANHANG SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE QLBANHANG;
END
GO

CREATE DATABASE QLBANHANG;
GO

USE QLBANHANG;
GO

-- 1. Bang Khach hang (customer)
CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name NVARCHAR(100) NOT NULL
);
GO

-- 2. Bang Nhan vien (employee)
CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name NVARCHAR(100) NOT NULL,
    salary FLOAT NOT NULL,
    supervisor_id INT NULL,
    CONSTRAINT FK_Employee_Supervisor FOREIGN KEY (supervisor_id) REFERENCES employee(employee_id)
);
GO

-- 3. Bang San pham (products)
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name NVARCHAR(100) NOT NULL,
    list_price FLOAT NOT NULL
);
GO

-- 4. Bang Don hang (orders)
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    order_date DATE NOT NULL,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    total FLOAT NOT NULL DEFAULT 0,
    CONSTRAINT FK_Orders_Customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT FK_Orders_Employee FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);
GO

-- 5. Bang Chi tiet don hang (lineItem)
CREATE TABLE lineItem (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price FLOAT NOT NULL,
    CONSTRAINT PK_LineItem PRIMARY KEY (order_id, product_id),
    CONSTRAINT FK_LineItem_Orders FOREIGN KEY (order_id) REFERENCES orders(order_id),
    CONSTRAINT FK_LineItem_Products FOREIGN KEY (product_id) REFERENCES products(product_id)
);
GO

-- =============================================
-- HAM VA THU TUC LUU TRU (UDF & STORED PROCEDURES)
-- =============================================

-- 3.4 Ham UDF tinh tong tien don hang (computeOrderTotal)
CREATE FUNCTION dbo.computeOrderTotal(@order_id INT)
RETURNS FLOAT
AS
BEGIN
    DECLARE @total FLOAT;
    SELECT @total = ISNULL(SUM(quantity * price), 0)
    FROM lineItem
    WHERE order_id = @order_id;
    RETURN @total;
END
GO

-- 3.5 Thu tuc them khach hang (sp_AddCustomer)
CREATE PROCEDURE sp_AddCustomer
    @customer_id INT,
    @customer_name NVARCHAR(100)
AS
BEGIN
    INSERT INTO customer(customer_id, customer_name)
    VALUES (@customer_id, @customer_name);
END
GO

-- 3.6 Thu tuc cap nhat khach hang (sp_UpdateCustomer)
CREATE PROCEDURE sp_UpdateCustomer
    @customer_id INT,
    @customer_name NVARCHAR(100)
AS
BEGIN
    UPDATE customer
    SET customer_name = @customer_name
    WHERE customer_id = @customer_id;
END
GO

-- 3.7 Thu tuc xoa khach hang (sp_DeleteCustomer, tu xoa don hang + chi tiet)
CREATE PROCEDURE sp_DeleteCustomer
    @customer_id INT
AS
BEGIN
    SET NOCOUNT ON;

    -- Xoa chi tiet don hang thuoc cac don hang cua khach hang nay
    DELETE FROM lineItem
    WHERE order_id IN (SELECT order_id FROM orders WHERE customer_id = @customer_id);

    -- Xoa cac don hang cua khach hang nay
    DELETE FROM orders
    WHERE customer_id = @customer_id;

    -- Xoa khach hang
    DELETE FROM customer
    WHERE customer_id = @customer_id;
END
GO

-- =============================================
-- DU LIEU MAU (SEED DATA)
-- =============================================

-- Du lieu nhan vien (Employee 2 phuc vu cho don hang tao moi trong Main.java)
INSERT INTO employee(employee_id, employee_name, salary, supervisor_id) VALUES
(1, N'Nguyen Van Truong', 15000000, NULL),
(2, N'Tran Thi Mai', 10000000, 1),
(3, N'Hoang Van Dung', 9000000, 1);

-- Du lieu khach hang (Khach hang 1 phuc vu cho test don hang trong Main.java)
INSERT INTO customer(customer_id, customer_name) VALUES
(1, N'Tran Van An'),
(2, N'Le Thi Binh'),
(3, N'Pham Van Cuong');

-- Du lieu san pham (San pham 2 va 3 phuc vu cho Main.java: addLineItem(111, 2, 2, 25.5)...)
INSERT INTO products(product_id, product_name, list_price) VALUES
(1, N'Ban phim co DareU', 450.0),
(2, N'Chuot khong day Logitech', 25.5),
(3, N'Tai nghe Gaming Sony', 80.0),
(4, N'Man hinh Dell 24 inch', 3200.0);

-- Du lieu don hang mau (Don 101 cho khach hang 1 phuc vu getOrdersByCustomer(1) & getLineItems(101))
INSERT INTO orders(order_id, order_date, customer_id, employee_id, total) VALUES
(101, '2026-11-01', 1, 2, 105.5),
(102, '2026-11-05', 2, 3, 450.0);

-- Du lieu chi tiet don hang mau cho don 101 (25.5 + 80.0 = 105.5)
INSERT INTO lineItem(order_id, product_id, quantity, price) VALUES
(101, 2, 1, 25.5),
(101, 3, 1, 80.0),
(102, 1, 1, 450.0);
GO
