#!/bin/bash
env=$1
mvn clean jar -P$1
java -jar springbootdemo.jar