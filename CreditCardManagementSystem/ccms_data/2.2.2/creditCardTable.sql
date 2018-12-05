USE cdw_sapp; 

DROP TABLE IF EXISTS cdw_sapp_credit_card;

CREATE TABLE cdw_sapp_credit_card ( 
transaction_id INT, 
timeid STRING, 
credit_card_no STRING, 
cust_ssn STRING, 
branch_code INT, 
transaction_type STRING, 
transaction_value DOUBLE 
) 
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY '\t' 
STORED AS TEXTFILE 
LOCATION '/user/maria_dev/Credit_Card_System/CDW_SAPP_CREDITCARD';
