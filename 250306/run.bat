@echo off
cls
echo delete class
del *.class

echo class number?
set /p fname=

echo compile...
javac -encoding utf8 Ex%fname%.java

echo run...
java Ex%fname%
pause