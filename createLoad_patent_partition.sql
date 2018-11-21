CREATE EXTERNAL TABLE patent_partitioned(
	patent INT,
	gdate INT,
	postate STRING,
	appyear INT,
	assignee INT,
	classcode INT,
	claims INT,
	nclass INT
)
PARTITIONED BY (gyear INT,country STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/maria_dev/patent_data/partition';

SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;

INSERT INTO TABLE patent_partitioned
PARTITION(gyear,country)
SELECT patent, gdate,postate,appyear,assignee,classcode,
claims,nclass,gyear,country 
FROM patent_external
WHERE gyear IN (1963,1999);