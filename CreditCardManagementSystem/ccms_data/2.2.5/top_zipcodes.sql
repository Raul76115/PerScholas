USE cdw_sapp;

SELECT branch_zip, ROUND(SUM(transaction_value),2) AS total_transaction_value 
FROM cdw_sapp_branch csb
JOIN cdw_sapp_credit_card csacc ON csb.branch_code=csacc.branch_code
GROUP BY branch_zip
ORDER BY total_transaction_value DESC LIMIT 20;
