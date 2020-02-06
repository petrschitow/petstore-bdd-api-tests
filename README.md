# petstore-bdd-api-tests
Some tests for petstore-api using BDD approach

### Technologies that were used in the project:
* Kotlin (main program language)
* Junit (test-runner)
* Cucumber (BDD)
* PicoContainer (DI. Share state between steps)
* RestAssured (For REST-requests)
* AssertJ (Pretty asserts)
* Gson (Operations with JSON)
* Hoplite (For parse .yaml config)

### Running tests:

1. Edit config (src/main/resources/): <br/>
```config-prod.yaml``` or ```config-test.yaml``` <br/>

1. Set environment (env should be test or prod. Default = test): <br/>
For windows run command in command line: <br/>
```set env=test```<br />

2. Run tests <br />
```mvn test -Dcucumber.filter.tags="@pet"``` - run tests only for pets <br/>
```mvn test -Dcucumber.filter.tags="@store"``` - run tests only for store <br/>
 
 
 ### Test reports: 
 After test execution you can find test reports in dir /target/cucumber <br/>
 Open file ```index.html``` in browser.
