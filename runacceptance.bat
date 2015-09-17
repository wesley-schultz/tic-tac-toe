cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\build\classes\main;swinglibrary-1.9.4.jar;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
cd ..