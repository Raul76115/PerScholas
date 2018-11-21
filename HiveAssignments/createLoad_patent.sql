CREATE EXTERNAL TABLE patent_external(
	patent INT,
	gyear INT,
	gdate INT,
	appyear INT,
	country STRING,
	postate STRING,
	assignee INT,
	classcode INT,
	claims INT,
	nclass INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/maria_dev/patent_data'
TBLPROPERTIES("skip.header.line.count"="1");

LOAD DATA LOCAL INPATH '/home/maria_dev/patent_data/apat63_99.txt'
OVERWRITE INTO TABLE patent_external;

