## How to add ojdbc6 driver

1. Download ojdbc6 11.2.0.4 from Oralce and save it to local.

https://www.oracle.com/technetwork/database/application-development/jdbc/downloads/index.html

2. Run mvn install

```
mvn install:install-file -Dfile=/Users/huan/Downloads/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Drsion=11.2.0.4 -Dpackaging=jar
```

3. Modify pom.xml
```
<dependency>
    <groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
	<version>11.2.0.4</version>
</dependency>

```