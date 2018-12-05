USE cdw_sapp;

SELECT quartus, ROUND(SUM(transactional_value))
FROM quarters_part
GROUP BY quartus;
