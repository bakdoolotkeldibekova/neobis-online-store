drop table users;

CREATE TABLE address(
  id bigint NOT NULL AUTO_INCREMENT,
  country varchar(100) NOT NULL,
  region varchar(100) NOT NULL,
  city varchar(100) NOT NULL,
  street varchar(100) NOT NULL,
  home varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(50) NOT NULL,
  phone varchar(50),
  session_key integer,
  address_id bigint,
  PRIMARY KEY (id),
  FOREIGN KEY (address_id) REFERENCES address(id)
);