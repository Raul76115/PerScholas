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
DBTABLE=CDW_SAPP_CUSTOMER 
sqoop job \
--create customer_job \
-- import \
-m1 \
--connect jdbc:mysql://${DBSERVER}/${DBNAME} \
--driver com.mysql.jdbc.Driver \
--query "SELECT ssn, \
CONCAT(UPPER(SUBSTR(first_name,1,2)),LOWER(SUBSTR(first_name,2))) AS first_name, \
LOWER(middle_name) AS middle_name, \
CONCAT(UPPER(SUBSTR(last_name,1,2)),LOWER(SUBSTR(first_name,2))) AS last_name, \
credit_card_no, \
CONCAT(apt_no,\",\",street_name) AS cust_address, \
cust_city,cust_state,cust_country,COALESCE(cust_zip,99999) AS cust_zip, \
CONCAT(RIGHT(CAST(cust_phone AS CHAR),3),\"-\", \
MID(CAST(cust_phone AS CHAR),4,3),\"-\", \
RIGHT(CAST(cust_phone AS CHAR),4)) AS cust_phone, \
cust_email,last_updated FROM ${DBTABLE} WHERE \$CONDITIONS" \
--target-dir /user/maria_dev/Credit_Card_System/${DBTABLE} \
--fields-terminated-by '\t'
