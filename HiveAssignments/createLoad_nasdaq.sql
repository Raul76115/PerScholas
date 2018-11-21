CREATE EXTERNAL TABLE nasdaq_daily (
	market STRING,
	stock_symbol STRING,
	adate STRING,
	stock_price_open FLOAT,
	stock_price_high FLOAT,
	stock_price_low FLOAT,
	stock_price_close FLOAT,
	stock_volume INT,
	stock_price_adj_close FLOAT
	)
	ROW FORMAT DELIMITED
	FIELDS TERMINATED BY ','
	STORED AS TEXTFILE
	LOCATION '/user/maria_dev/nasdaq_data/daily'
	TBLPROPERTIES("skip.header.line.count"="1");
	
	LOAD DATA LOCAL INPATH '/home/maria_dev/nasdaq_data/NASDAQ_daily_prices_A_sample.csv'
	OVERWRITE INTO TABLE nasdaq_daily;

CREATE EXTERNAL TABLE nasdaq_dividends (
	market STRING,
	stock_symbol STRING,
	adate STRING,
	dividends DOUBLE
	)
	ROW FORMAT DELIMITED
	FIELDS TERMINATED BY ','
	STORED AS TEXTFILE
	LOCATION '/user/maria_dev/nasdaq_data/dividends'
	TBLPROPERTIES("skip.header.line.count"="1");
	
LOAD DATA LOCAL INPATH '/home/maria_dev/nasdaq_data/NASDAQ_dividends_A.csv'
OVERWRITE INTO TABLE nasdaq_dividends;