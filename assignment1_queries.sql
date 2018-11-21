SELECT COUNT(DISTINCT patent) AS Number_Patent_1963
FROM patent_partitioned
WHERE gyear = 1963;

SELECT country, COUNT(DISTINCT patent) AS Number_Patent_1999
FROM patent_external
WHERE gyear = 1999
GROUP BY country;