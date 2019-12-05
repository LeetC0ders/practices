/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package practices;

import practices.di.AppComponent;
import practices.di.DaggerAppComponent;

public class App {

    private static int problemCounter = 0;
    private AppComponent appComponent = DaggerAppComponent.create();

    public String getGreeting() {
        return "Hello, welcome to LeetCode practice";
    }
    private AppComponent getAppComponent() { return appComponent; }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getGreeting());

        printProblemSolved(app.getAppComponent().provideFizzBuzz().getName());
        printProblemSolved(app.getAppComponent().provideTwoSum().getName());
        printProblemSolved(app.getAppComponent().provideAddTwoNumbers().getName());

        printProblemSolvedPendingTest(app.getAppComponent().provideLongestSubstringWithoutRepeatingCharacters().getName());
        printProblemSolvedPendingTest(app.getAppComponent().provideSplitStringToBalancedString().getName());
        printProblemSolvedPendingTest(app.getAppComponent().provideCountingBits().getName());
    }

    private static void printProblemSolved(String problemName) {
        System.out.println("Problem #" + problemCounter++ + " problem name: " + problemName + " completed.");
    }

    private static void printProblemSolvedPendingTest(String problemName) {
        System.out.println("*NEED unit test* Problem #" + problemCounter++ + " problem name: " + problemName + " completed.");
    }
}
