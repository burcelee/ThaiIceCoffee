#!/bin/sh
mkdir -p bin
find src  -type f -name "*.java" > java_files
javac @java_files -d bin
/bin/rm java_files
