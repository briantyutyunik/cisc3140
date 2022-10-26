#!/bin/bash 

DATE1='date -j -f '%m/%d/%y' $1 +%s'
DATE2='date -j -f '%m/%d/%y' $2 + %s'

diff=$DATE2-$DATE1
days=$(($diff / 86400))

echo "The difference in days is $days days"
