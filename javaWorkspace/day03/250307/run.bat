@echo off
cls
echo delete class
del *.class

echo class number?
set /p fname=

echo make dist
mkdir dist

echo compile...
javac -d dist -encoding utf8 Ex%fname%.java

echo run...
cd dist
java Ex%fname%
cd..
rmdir /s /q dist
pause