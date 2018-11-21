SELECT stock_symbol, SUM(stock_volume)
	FROM nasdaq_daily_partitioned
	WHERE stock_price_close > 5.00
	GROUP BY stock_symbol;
	
	SELECT stock_symbol, MAX(stock_price_high)
	FROM nasdaq_daily_partitioned
	GROUP BY stock_symbol;
	
	SELECT stock_symbol, MAX(dividends)
	FROM nasdaq_dividends_partitioned
	GROUP BY stock_symbol;
	
	SELECT ndvp.stock_symbol,MAX(dividends), MAX(stock_price_high)
	FROM nasdaq_daily_partitioned ndp
	JOIN nasdaq_dividends_partitioned ndvp
	ON ndp.stock_symbol=ndvp.stock_symbol
	GROUP BY ndvp.stock_symbol;