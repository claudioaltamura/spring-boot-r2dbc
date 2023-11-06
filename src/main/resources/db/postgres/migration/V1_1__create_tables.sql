CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS department
(
    id uuid PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    name varchar(64)
);

CREATE TABLE IF NOT EXISTS employee
(
    id uuid PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    first_name  varchar(64),
    last_name   varchar(64),
    date_of_birth  DATE NOT NULL,
    department uuid NOT NULL CONSTRAINT employee_foreign_key1 REFERENCES department (id)
);