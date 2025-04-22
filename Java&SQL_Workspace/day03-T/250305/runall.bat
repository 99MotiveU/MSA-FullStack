@echo off
cls
echo delete class
del *.class

echo compile...
javac -encoding utf8 Ex02.java
rem javac -encoding utf8 Ex03.java
javac Ex04.java
javac -encoding utf8 Ex05.java
javac -encoding utf8 Ex06.java

echo run...
echo Ex02
java Ex02
rem java Ex03
echo Ex04
java Ex04
echo Ex05
java Ex05
echo Ex06
java Ex06
pause