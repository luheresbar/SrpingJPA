USE jpa_audit_db;

ALTER TABLE History
    ADD COLUMN user VARCHAR(255);
