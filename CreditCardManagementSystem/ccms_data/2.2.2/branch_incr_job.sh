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
DBTABLE=CDW_SAPP_BRANCH
sqoop job \
--create branch_incr_job \
-- import \
-m1 \
--connect jdbc:mysql://${DBSERVER}/${DBNAME} \
--driver com.mysql.jdbc.Driver \
--query "SELECT branch_code,branch_name,branch_street, \
branch_city,branch_state,COALESCE(branch_zip,99999) AS branch_zip, \
CONCAT(RIGHT(CAST(branch_phone AS CHAR),3),\"-\", \
MID(CAST(branch_phone AS CHAR),4,3),\"-\", \
RIGHT(CAST(branch_phone AS CHAR),4)) AS branch_phone, \
NOW() AS last_updated\
FROM ${DBTABLE} WHERE \$CONDITIONS" \
--incremental append \
--check-column last_updated \
--last-value '2018-04-18 20:51:47.0' \
--target-dir /user/maria_dev/Credit_Card_System/${DBTABLE} \
--fields-terminated-by '\t'
