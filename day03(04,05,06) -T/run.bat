@echo off
rem no print
cls
echo class number?
set /p fname=

mkdir dist
javac -d dist -encoding utf8 Ex%fname%.java
cd dist
java Ex%fname%
cd ..
rmdir /s /q dist
pause