#!/usr/bin/env bash

NOOFITERATIONS=$1

export users=10

echo $users
START=1
END=$NOOFITERATIONS

for i in $(eval echo "{$START..$END}")
do
  export iteration="$i"
  echo "$i"
  echo "$iteration"
  mvn clean test
done

