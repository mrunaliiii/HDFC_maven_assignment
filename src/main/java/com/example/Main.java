package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}

//mvn clean package
/*
. clean

🧹 Deletes the existing compiled files and output from previous builds:

Removes the target/ directory (where compiled code and JARs live)

Ensures you're starting from a clean slate (avoids stale builds)

2. package

📦 Compiles your project and creates a JAR (or WAR) file:

Compiles your Java code from src/main/java

Copies resources from src/main/resources

Runs any configured plugins (like the Shade plugin)

Packages everything into a final JAR file in the target/ folder
 */
//java -jar target/Maven1-1.0-SNAPSHOT.jar
