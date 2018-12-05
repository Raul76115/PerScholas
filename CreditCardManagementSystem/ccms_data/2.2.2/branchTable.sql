USE cdw_sapp;

DROP TABLE IF EXISTS cdw_sapp_branch;
 
CREATE TABLE cdw_sapp_branch( 
branch_code INT, 
branch_name STRING, 
branch_street STRING, 
branch_city STRING, 
branch_state STRING, 
branch_zip INT, 
branch_phone STRING, 
last_updated TIMESTAMP 
)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY '\t' 
STORED AS TEXTFILE 
LOCATION '/user/maria_dev/Credit_Card_System/CDW_SAPP_BRANCH';
