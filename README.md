# Agile-board

A simple Agile board similar to [Trello.](https://trello.com/) This tool was built for a design cum refactoring exercise.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
### Dependencies to be installed

```
Postgres 9.4.15
Gradle 4.2.1
Jetty 9.4.7
```

#### Building the app

```
./gradlew createDB
./gradlew clean build
```

#### Running the app

```
./gradlew appRun
```

**Note**: The app will not unless the env var 'DATABASE_URL' is set with the right database URL.
```
export DATABASE_URL="postgres://<username>:<password>@<server>:<port>/<dbName>"
```
Example :-
```bash
export DATABASE_URL="postgres://postgres:postgres@localhost:5432/prorg"
```

#### Deploy app to Heroku

```
./gradlew deploy
```
