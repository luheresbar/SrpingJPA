USE jpa_audit_db;
CREATE TABLE History
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255),
    operation VARCHAR(255),
    date      TIMESTAMP
);