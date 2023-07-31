# Running Java Code and JUnit Tests with Eclipse IDE

This guide will show you how to run and test the `HowitzerSimulator` program using Eclipse IDE. 

Before starting, please download the `HowitzerSimulator` folder from each MVP branch you are interested in running and testing.

## Running Your Main Java Program

1. **Open Eclipse IDE and Import Your Project**
    - Launch Eclipse IDE. Navigate to the 'File' menu and select 'Open Projects from File System...'.
    - In the 'Import Projects' dialog box, click 'Directory...' and find your downloaded `HowitzerSimulator` directory. Select it and click 'Finish'.

2. **Running Your Code**
    - In the 'Package Explorer' (usually on the left side of the screen), expand your project folder and the 'src' folder. 
    - Find the `HowitzerSimulator.java` file, right-click on it, and select 'Run As' > 'Java Application'.

Your `HowitzerSimulator.java` program should now run and output the results in the Eclipse Console.

## Running JUnit Tests

1. **Navigate to Your Test Folder**
    - In the 'Package Explorer', expand your project folder and the 'test' folder.

2. **Running the Tests**
    - Right-click on your test file (`TestHowitzerSimulatorTest.java`) and select 'Run As' > 'JUnit Test'.
    - The results of your tests will be displayed in the 'JUnit' tab. Successful tests will be marked with a green check, while failed tests will show a red X.

By default, Eclipse will run all the test methods in the selected test file. If you want to run a single test method, open your test file, right-click the name of the method in the editor, and select 'Run As' > 'JUnit Test'.

Remember, to run JUnit tests, you need to have the JUnit library configured in your build path. If it's not set up already, you can add it by right-clicking on your project > 'Build Path' > 'Add Libraries...' > 'JUnit' > 'Next' > select the latest JUnit version > 'Finish'.
