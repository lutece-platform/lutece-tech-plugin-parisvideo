DROP TABLE IF EXISTS parisvideo_account;

CREATE TABLE parisvideo_account (
  id_account INT DEFAULT '0' NOT NULL,
  name varchar(255) DEFAULT NULL,
  login varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  date_update timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY  (id_account)
);