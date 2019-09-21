- cd root dir (project root or /projects/PerCapitalIncome)

- compile all java  classes 
   javac -d "bin"  $(find . -name "*.java")  or javac $(find . -name "*.java")
- run main class 
   java -cp "bin" com/abc/perCapitalIncome/main/MainApp
 