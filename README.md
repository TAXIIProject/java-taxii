# java-taxii

A Java library for handling TAXII Messages and invoking TAXII Services.
For more information, see [http://taxiiproject.github.io/](http://taxiiproject.github.io/).

[![Build Status](https://travis-ci.org/TAXIIProject/java-taxii.svg?branch=master)](https://travis-ci.org/TAXIIProject/java-taxii)

## <a name="overview"></a>Overview

A primary goal of java-taxii is to remain faithful to both the TAXII 
specifications and to customary Java practices. java-taxii is designed to be 
intuitive both to Java developers and XML developers.

## <a name="versioning"></a>Versioning

Releases of java-taxii will comply with the Semantic Versioning specification
at [http://semver.org/](http://semver.org/).  Java-taxii is currently under active development;
see TODO.txt for a tentative roadmap.

## <a name="releases"></a>Releases

v1.1.0 - Initial release. Targets TAXII 1.1 and 1.0.

v1.1.0.1 - Built to target Java 7 instead of 8.

Releases are distributed via the Maven Central Repository. 

### <a name="maven_dependency_info"></a>Apache Maven:

	<dependency>
	  <groupId>org.mitre.taxii</groupId>
	  <artifactId>taxii</artifactId>
	  <version>1.1.0.1</version>
	</dependency>

### <a name="gradle_dependency_info"></a>Gradle:

	compile 'org.mitre.taxii:taxii:1.1.0.1'

### <a name="ivy__dependency_info"></a>Apache Ivy:

	<dependency org="org.mitre.taxii" name="taxii" rev="1.1.0.1" />

## <a name="snapshots"></a>Snapshots

Snapshots are being pushed to 

[https://oss.sonatype.org/content/repositories/snapshots/org/mitre/taxii/taxii](https://oss.sonatype.org/content/repositories/snapshots/org/mitre/taxii/taxii/)

Users using Apache Maven for example can simply retrieve java-taxii directly via the Central Repository:

     <repositories>
       <repository>
         <id>snapshots-repo</id>
         <url>https://oss.sonatype.org/content/repositories/snapshots</url>
         <releases><enabled>false</enabled></releases>
         <snapshots><enabled>true</enabled></snapshots>
       </repository>
     </repositories>
	
	<dependencies>
		<dependency>
			<groupId>org.mitre.taxii</groupId>
			<artifactId>taxii</artifactId>
			<version>1.1-SNAPSHOT</version>
		</dependency>
	</dependencies>

[Release](#releases) artifacts appear in the Maven Central Repository.

## Building

This project uses Gradle 2.2+ as the primary build tool.  See
[http://www.gradle.org](http://www.gradle.org) for details.

Common targets (see a complete list by running 'gradle tasks'):

    clean             - Deletes the build directory.
    build             - Builds the project, creates the jar, runs the tests
    generate          - Runs the JAXB xjc compiler against the schemas in 
                        src/main/xsd, generating java in src/generated/java
    cleanGenerate    - Removes the src/generated/java directory
    compileGenerated  - Compiles the generated code
    
    
To run gradle behind a web proxy, set the following properties in a
gradle.properties file in your USER_HOME/.gradle directory. See
[the Gradle documentation](https://docs.gradle.org/current/userguide/build_environment.html#sec:accessing_the_web_via_a_proxy)
for details.

```INI
systemProp.http.proxyHost=www.somehost.org
systemProp.http.proxyPort=8080
systemProp.http.proxyUser=userid
systemProp.http.proxyPassword=password
systemProp.http.nonProxyHosts=*.nonproxyrepos.com|localhost
systemProp.https.proxyHost=www.somehost.org
systemProp.https.proxyPort=8080
systemProp.https.proxyUser=userid
systemProp.https.proxyPassword=password
systemProp.https.nonProxyHosts=*.nonproxyrepos.com|localhost
```


## Feedback

Please provide feedback and/or comments on open issues to taxii@mitre.org.
