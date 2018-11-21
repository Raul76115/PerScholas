CREATE EXTERNAL TABLE nasdaq_dividends_partitioned (
	market STRING,
	adate STRING,
	dividends DOUBLE
	)
	PARTITIONED BY (stock_symbol STRING)
	ROW FORMAT DELIMITED
	FIELDS TERMINATED BY ','
	STORED AS TEXTFILE
	LOCATION '/user/maria_dev/nasdaq_data/dividends/partition';
	
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
	
	INSERT INTO TABLE nasdaq_dividends_partitioned
	PARTITION(stock_symbol)
	SELECT market,adate,dividends,stock_symbol
	FROM nasdaq_dividends;