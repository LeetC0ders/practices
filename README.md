# practices

Right now I have finished the setup of this project

## How to build?
```zsh
./gradlew clean build
```
The build will check the ```Solution``` impl class you made and run UnitTest on them. When you create a Solution of your own
you will need to make sure the test are in place, and your solution can pass all the UnitTest you made. ```./gradlew build```
is a good way of checking this.

## How to run?
```zsh
./gradlew run
```
Running this project will give you a overview of all the solutions that we have answered. You will be able to see the order
of when a solution is made, and the name of the solution. Currently, all the solution that is printed at main is solved.

---
This project uses the Dagger 2 lib.
- All the solution to a leetCode problem must implement the interface called ```Solution.kt```
  - This interface provide 2 methods:
    1. ```fun getName(): String``` You need to provide a name to your solution. i.e ```"FizzBuzz"```
    2. ```fun solve(solutionIn: T?): V``` This method layout what you take as an input to solve this question, and what to
    output after you solve the question, it can be ```Int```, ```String```, ```Any``` or ```Unit``` depends on the question.
    
    ```kotlin
    interface Solution<T, V> {
      fun getName(): String
      fun solve(solutionIn: T?): V
    }
    ```
    
- Every solution you provided as an implementation in ```questions``` package needs to be a ```@Singleton``` and has```@Inject```
annotation tagged to it. This is so we can use dagger to provide your solution class for testing and main.

Happy leetCoding.
