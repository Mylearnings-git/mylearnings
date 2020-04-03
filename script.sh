#!/bin/bash
USER_ID="1000"
if [[ ${UID} == 0 ]]
 then
 echo "The script is being executed with root privilege"
 read -p 'Enter the username: ' USER_NAME
 read -p 'Enter the password: ' PASSWORD
 read -p 'Enter your real name: ' REAL_NAME
 useradd -m  "${USER_NAME}"
   if [[ $? -ne 0  ]]
   then
   echo "The userid cannot be created"
   exit 1
   fi   
	   
echo ${PASSWORD} | passwd --stdin ${USER_NAME}
     if [[ $? -ne 0 ]] 
     then
     echo "The password cannot be created"
     exit 1
     fi     
passwd -e "${USER_NAME}"
tail -3 /etc/passwd   
else
 echo "The script is not being executed with root privilege"
fi

	
