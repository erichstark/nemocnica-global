#!/bin/bash

PID=$(netstat -tulpn | grep :8080 | sed 's/\s\s*/ /g' |cut -d' ' -f7 | cut -d'/' -f1 | awk '{ print $1 }')
if [ -z "$PID" ]
then
    echo "Application is already stopped"
else
    echo "Stoping application with PID "$PID
    kill $PID
fi