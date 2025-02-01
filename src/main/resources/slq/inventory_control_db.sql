-- Category Table
create table Category (
    id SERIAL primary key,
    name VARCHAR(100) not null,
    description text
);

-- Supplier Table
CREATE TABLE Supplier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    address TEXT
);

-- Product Table
CREATE TABLE Product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    purchase_price DECIMAL(10,2) NOT NULL,
    sale_price DECIMAL(10,2) NOT NULL,
    current_stock INT NOT NULL DEFAULT 0,
    minimum_stock INT NOT NULL DEFAULT 0,
    category_id INT,
    supplier_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES Category(id) ON DELETE SET NULL,
    CONSTRAINT fk_supplier FOREIGN KEY (supplier_id) REFERENCES Supplier(id) ON DELETE SET NULL
);

-- Inventory Table (Stock Movements)
CREATE TABLE Inventory (
    id SERIAL PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    movement_type VARCHAR(10) CHECK (movement_type IN ('ENTRY', 'EXIT', 'ADJUSTMENT')) NOT NULL,
    reason TEXT,
    movement_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE
);


-- Sales Table
CREATE TABLE Sale (
    id SERIAL PRIMARY KEY,
    sale_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL
);

-- Sale Detail Table
CREATE TABLE SaleDetail (
    id SERIAL PRIMARY KEY,
    sale_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_sale FOREIGN KEY (sale_id) REFERENCES Sale(id) ON DELETE CASCADE,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE
);

-- User Table (For authentication and roles)
CREATE TABLE User_System (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(10) CHECK (role IN ('ADMIN', 'SELLER')) NOT NULL
);

-- Tabla de Roles
CREATE TABLE Role (
    id SERIAL primary key,
    name VARCHAR(50) unique not null
);

-- Insertamos algunos roles por defecto
INSERT INTO Role (name) VALUES
('ADMIN'),
('SELLER');

-- Modificamos la tabla de Usuarios para hacer referencia a la tabla Role
ALTER TABLE User_System
ADD COLUMN role_id INT,
ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES Role(id) ON DELETE SET NULL;
