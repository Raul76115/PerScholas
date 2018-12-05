#!/bin/sh 
lines=`cat db.properties` 
function setProperties(){ 
	while read LINE 
	do 
	  KEY=`echo $LINE|cut -d= -f1` 
	  VALUE=`echo $LINE|cut -d= -f2` 
	  if [ "$KEY" == "DBSERVER" ]; then 
		DBSERVER=${VALUE} 
	  elif [ "$KEY" == "DBNAME" ]; then 
		DBNAME=${VALUE} 
	  elif [ "$KEY" == "DBUSER" ]; then 
		DBUSER=${VALUE} 
	  elif [ "$KEY" == "DBPASSWORD" ]; then 
		DBPASSWORD=${VALUE} 
	  fi 
	done <<< "echo -e $lines" 
} 
setProperties 
DBTABLE=CDW_SAPP_CREDITCARD 
sqoop job \
--meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop \
--create time_incr_meta_job \
-- import \
-m1 \
--connect jdbc:mysql://${DBSERVER}/${DBNAME} \
--driver com.mysql.jdbc.Driver \
--query "SELECT transaction_id, \
CONCAT(CAST(year AS CHAR),CAST(month AS CHAR),CAST(day AS CHAR)) AS timeid, \
CAST(day AS CHAR) AS day,CAST(month AS CHAR) AS month, \
(CASE WHEN month < 4 THEN "1" \
WHEN month >= 4 AND month < 7 THEN "2" \
WHEN month >= 6 AND month < 10 THEN "3" \
WHEN month >= 9 AND month <13 THEN "4" \
ELSE "NULL" \
END) AS quartus,CAST(year AS CHAR) AS year \
FROM ${DBTABLE} WHERE \$CONDITIONS" \
--incremental append \
--check-column transaction_id \
--last-value '46694' \
--target-dir /user/maria_dev/Credit_Card_System/CDW_SAPP_TIME \
--fields-terminated-by '\t'
