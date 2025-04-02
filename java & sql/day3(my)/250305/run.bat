@echo off
cls
echo delete class
del *.class

rem no print

set fname=Ex06

echo compile...
javac -encoding utf-8 %fname%.java

echo run...
java %fname%
pause   rem press button...