# java-taxii

A Java library for handling TAXII Messages and invoking TAXII Services.
For more information, see http://taxii.mitre.org/.

## Overview

A primary goal of java-taxii is to remain faithful to both the TAXII 
specifications and to customary Java practices. java-taxii is designed to be 
intuitive both to Java developers and XML developers.

## Versioning

Releases of java-taxii will comply with the Semantic Versioning specification
at http://semver.org/.  Java-taxii is currently under active development;
see TODO.txt for a tentative roadmap.  Releases will be announced on the
[TAXII discussion list](http://taxii.mitre.org/community/registration.html).

## Building

This project uses Gradle 1.12+ as the primary build tool.  See
www.gradle.org for details.

Common targets (see a complete list by running 'gradle tasks'):

    clean             - Deletes the build directory.
    build             - Builds the project, creates the jar, runs the tests
    generate          - Runs the JAXB xjc compiler against the schemas in 
                        src/main/xsd, generating java in src/generated/java
    cleanGenerate    - Removes the src/generated/java directory
    compileGenerated  - Compiles the generated code
    
    
To run gradle behind a web proxy, set the following properties in a
gradle.properties file in your USER_HOME/.gradle directory. See
http://www.gradle.org/docs/current/userguide/build_environment.html#sec:accessing_the_web_via_a_proxy
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

You are encouraged to provide feedback by commenting on open issues or 
signing up for the [TAXII discussion list](http://taxii.mitre.org/community/registration.html)
and posting your questions.