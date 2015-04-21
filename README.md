# Aplikacja na sterydach - wprowadzenie do Spring boot

This repository contains the source code produced during the live-coding session at ATP 2015.

## How to build

- Clone this repository (or download it as a zip file)
- Build the code:
    - On Linux / Mac - open your terminal, navigate to the project folder and execute:
        - `./gradlew clean build`
    - On Windows, open cmd, navigate to the project folder and execute:
        - `gradlew.bat clean build`
        
## How to run

Either with a regular `java -jar` command
- `java -jar <project_root_folder>/build/libs/atp_spring_intro-0.0.1-SNAPSHOT.jar`

Or using the spring-boot-gradle plugin:
- `./gradlew bootRun` (`gradlew.bat bootRun` on Windows)

