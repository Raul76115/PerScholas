USE cdw_sapp;

CREATE EXTERNAL TABLE quarters_part
(
transaction_id int,
transactional_value double
)
PARTITIONED BY (quartus string)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\t'
STORED AS TEXTFILE
LOCATION '/user/maria_dev/redit_Card_System/CDW_SAPP_TIME_EXT';

SET hive.exec.dynamic.partition=true; 
SET hive.exec.dynamic.partition.mode=nonstrict;

INSERT INTO TABLE quarters_part
PARTITION(quartus)
SELECT cst.transaction_id, transaction_value,quartus
FROM cdw_sapp_credit_card cscc
JOIN cdw_sapp_time cst ON cscc.transaction_id=cst.transaction_id;


