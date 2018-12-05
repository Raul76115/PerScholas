USE cdw_sapp; 

DROP TABLE IF EXISTS cdw_sapp_time;

CREATE TABLE cdw_sapp_time( 
transaction_id INT,
timeid STRING, 
day STRING, 
month STRING, 
quartus STRING, year STRING 
) 
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY '\t' 
STORED AS TEXTFILE 
LOCATION '/user/maria_dev/Credit_Card_System/CDW_SAPP_TIME';
