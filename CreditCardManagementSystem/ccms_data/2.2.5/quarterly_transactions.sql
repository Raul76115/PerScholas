USE cdw_sapp;

SELECT quartus, ROUND(SUM(transaction_value),2) AS total_transaction_values
FROM cdw_sapp_credit_card cscc
JOIN cdw_sapp_time cst ON cscc.transaction_id=cst.transaction_id
GROUP BY quartus;
