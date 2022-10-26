#!/bin/bash

isModified = inotifywait -m -e modify $1

compile() {
if $isModified
then 
   javac $1
fi
}

run() {
for var in $@
do
if ! $isModified
then
   java $var
fi
done
}

compile $1

run $@

