- cd root dir (project root or /projects/PerCapitalIncome)

- compile all java  classes 
   javac -d "bin"  $(find . -name "*.java")  or javac $(find . -name "*.java")
- run main class 
   java -cp "bin" com/abc/perCapitalIncome/main/MainApp
   
   
  
  run Spring boot application in backgound
nohup mvn spring-boot:run 2> error.log > output.log &
 nohup mvn spring-boot:run &> output.log &
 
 free -m
 