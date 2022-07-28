#!/bin/bash
rm -rf target
mkdir target
javac -d ./target src/java/edu/school21/printer/*/*.java
java -cp ./target edu/school21/printer/app/Program . 0 /Users/aseptimu/IdeaProjects/Piscine-Java/day04/ex01/ImagesToChar/src/resources/image.bmp