CREATE EXTERNAL TABLE nasdaq_daily_partitioned (
	market STRING,
	adate STRING,
	stock_price_open FLOAT,
	stock_price_high FLOAT,
	stock_price_low FLOAT,
	stock_price_close FLOAT,
	stock_volume INT,
	stock_price_adj_close FLOAT
	)
	PARTITIONED BY (stock_symbol STRING)
	ROW FORMAT DELIMITED
	FIELDS TERMINATED BY ','
	STORED AS TEXTFILE
	LOCATION '/user/maria_dev/nasdaq_data/daily/partition';
	
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
	
	INSERT INTO TABLE nasdaq_daily_partitioned 
	PARTITION(stock_symbol)
	SELECT market,adate,stock_price_open,stock_price_high,stock_price_low,stock_price_close,
	stock_volume,stock_price_adj_close,stock_symbol
	FROM nasdaq_daily;