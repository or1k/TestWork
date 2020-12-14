# Test work

Cover with autotests the main functionality

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


## Running the tests
* Login test
```
mvn -Dtest=OwnerLogin test
```
* User Section test. Includes registration, edit and delete user
```
mvn -Dtest=UsersTests test
```
* Company section tests. Includes registration, edit and delete user
```
mvn -Dtest=CompanyTests test
```
* Subject section test. Includes add new subject
```
mvn -Dtest=SubjectsTests test
```
* Analystics section test. Includes checking values in statistics in each block
```
mvn -Dtest=AnalyticsTests test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors
* **Alexandr Vasinskyi** - *Initial work* - [or1k](https://github.com/or1k)
## Info
* If the test fails, you can find a screenshot in \\build\reports\tests


