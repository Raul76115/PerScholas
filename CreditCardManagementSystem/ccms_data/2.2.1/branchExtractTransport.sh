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
sqoop import \
--connect jdbc:mysql://${DBSERVER}/${DBNAME} \
--driver com.mysql.jdbc.Driver \
--username ${DBUSER} \
--password ${DBPASSWORD} \
--query "SELECT branch_code,branch_name,branch_street, \
branch_city,branch_state,COALESCE(branch_zip,99999) AS branch_zip, \
CONCAT(RIGHT(CAST(branch_phone AS CHAR),3),\"-\", \
MID(CAST(branch_phone AS CHAR),4,3),\"-\", \
RIGHT(CAST(branch_phone AS CHAR),4)) AS branch_phone, \
last_updated FROM ${DBTABLE} WHERE \$CONDITIONS" \
-m 1 \
--incremental append \
--check-column last_updated \
--target-dir /user/maria_dev/Credit_Card_System/${DBTABLE} \
--fields-terminated-by '\t'
