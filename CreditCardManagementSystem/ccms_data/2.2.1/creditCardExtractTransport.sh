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
sqoop import \
--connect jdbc:mysql://${DBSERVER}/${DBNAME} \
--driver com.mysql.jdbc.Driver \
--username ${DBUSER} \
--password ${DBPASSWORD} \
--query "SELECT transaction_id, \
CONCAT(CAST(year AS CHAR),CAST(month AS CHAR),CAST(year AS CHAR)) AS timeid, \
credit_card_no,cust_ssn,branch_code, \
transaction_type,transaction_value \
FROM ${DBTABLE} WHERE \$CONDITIONS" \
-m 1 \
--incremental append \
--check-column transaction_id \
--target-dir /user/maria_dev/Credit_Card_System/${DBTABLE} \
--fields-terminated-by '\t'
