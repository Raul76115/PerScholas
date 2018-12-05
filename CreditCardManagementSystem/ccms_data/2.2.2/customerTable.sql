USE cdw_sapp; 

DROP TABLE IF EXISTS cdw_sapp_customer;

CREATE TABLE cdw_sapp_customer( 
ssn STRING, 
first_name STRING, 
middle_name STRING, 
last_name STRING, 
credit_card_no STRING, 
cust_address STRING, 
cust_city STRING, 
cust_state STRING, 
cust_country STRING, 
cust_zip INT, 
cust_phone STRING, 
cust_email STRING, 
last_updated TIMESTAMP 
) 
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY '\t' 
STORED AS TEXTFILE 
LOCATION '/user/maria_dev/Credit_Card_System/CDW_SAPP_CUSTOMER';
