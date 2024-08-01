CREATE TABLE Customers (
        customer_id INT PRIMARY KEY,
        first_name VARCHAR(50),
        middle_name VARCHAR(50),
        last_name VARCHAR(50),
        business_name VARCHAR(100),
        email_address VARCHAR(255) UNIQUE,
        phone_number VARCHAR(20) UNIQUE,
        address VARCHAR(255),
        account_number VARCHAR(20),
        account_name VARCHAR(100)
        );

        -- Beneficiary Details Table:
        CREATE TABLE Beneficiary_Details (
        beneficiary_id INT PRIMARY KEY,
        first_name VARCHAR(50),
        middle_name VARCHAR(50),
        last_name VARCHAR(50),
        business_name VARCHAR(100),
        email_address VARCHAR(255),
        address VARCHAR(255),
        bank_name VARCHAR(100),
        bank_id INT,
        swift_code VARCHAR(50),
        country VARCHAR(100),
        city VARCHAR(100)
        );

        -- Guarantee Applications Table:
        CREATE TABLE Guarantee_Applications (
        application_id INT PRIMARY KEY,
        customer_id INT,
        bank_id INT,
        guarantee_amount DECIMAL(18, 2),
        validity_period DATE,
        beneficiary_name VARCHAR(255),
        status VARCHAR(50),
        FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
        FOREIGN KEY (bank_id) REFERENCES Banks(bank_id)
        );

        -- Goods and Shipment Details Table:
        CREATE TABLE Goods_Shipment_Details (
        goods_id INT PRIMARY KEY,
        goods_description TEXT,
        quantity INT,
        value DECIMAL(18, 2),
        country_of_origin VARCHAR(100),
        port_of_loading VARCHAR(100),
        port_of_discharge VARCHAR(100),
        shipment_date DATE,
        bill_of_lading_airway_bill_no VARCHAR(100),
        invoice_no VARCHAR(100)
        );

        -- Guarantee Details Table:
        CREATE TABLE Guarantee_Details (
        guarantee_id INT PRIMARY KEY,
        application_id INT,
        currency VARCHAR(3),
        exchange_rate DECIMAL(18, 6),
        amount DECIMAL(18, 2),
        issue_date DATE,
        expiry_date DATE,
        digital_signature BLOB,
        document_path VARCHAR(255),
        status VARCHAR(50),
        FOREIGN KEY (application_id) REFERENCES Guarantee_Applications(application_id)
        );

        -- Documents Table:
        CREATE TABLE Documents (
        document_id INT PRIMARY KEY,
        guarantee_id INT,
        document_name VARCHAR(255),
        document_type ENUM('contract', 'invoice', 'certificate'),
        document_path VARCHAR(255),
        uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (guarantee_id) REFERENCES Guarantee_Details(guarantee_id)
        );

        -- Security Details Table:
        CREATE TABLE Security_Details (
        security_id INT PRIMARY KEY,
        application_id INT,
        type VARCHAR(50),
        charge_account VARCHAR(20),
        currency VARCHAR(3),
        amount DECIMAL(18, 2),
        FOREIGN KEY (application_id) REFERENCES Guarantee_Applications(application_id)
        );

        -- Banks Table:
        CREATE TABLE Banks (
        bank_id INT PRIMARY KEY,
        bank_name VARCHAR(100),
        contact_person VARCHAR(100),
        phone_number VARCHAR(20),
        email_address VARCHAR(255),
        address VARCHAR(255),
        country VARCHAR(100),
        city VARCHAR(100)
        );

        -- Bank Accounts Table:
        CREATE TABLE Bank_Accounts (
        account_id INT PRIMARY KEY,
        bank_Zxcccccccid INT,
        account_number VARCHAR(20),
        account_type VARCHAR(50),
        balance DECIMAL(18, 2),
        FOREIGN KEY (bank_id) REFERENCES Banks(bank_id)
        );

        -- Guarantees Issued Table:
        CREATE TABLE Guarantees_Issued (
        guarantee_id INT PRIMARY KEY,
        application_id INT,
        issue_date DATE,
        expiry_date DATE,
        digital_signature BLOB,
        document_path VARCHAR(255),
        FOREIGN KEY (application_id) REFERENCES Guarantee_Applications(application_id) ON DELETE CASCADE
        );