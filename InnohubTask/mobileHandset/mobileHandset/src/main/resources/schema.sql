DROP TABLE IF EXISTS TBL_EMPLOYEES;
  
CREATE TABLE MOBILE_HANDSET (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  brand VARCHAR(250) NOT NULL,
  picture VARCHAR(250) NOT NULL,
  announceDate VARCHAR(250) DEFAULT NULL,
  priceEur  VARCHAR(250) DEFAULT NULL,
  sim   VARCHAR(250) DEFAULT NULL,
  resolution VARCHAR(250) DEFAULT NULL,
  audioJack VARCHAR(250) DEFAULT NULL,
  gps VARCHAR(250) DEFAULT NULL,
  battery VARCHAR(250) DEFAULT NULL
);