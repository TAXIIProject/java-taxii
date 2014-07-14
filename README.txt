This project uses Gradle 1.12+ as the primary build tool.  See
www.gradle.org for details.

Common targets (see a complete list by running 'gradle tasks'):

    clean       - Deletes the build directory.
    build       - Builds the project, creates the jar, runs the tests
    xjc         - Runs the JAXB xjc compiler against the schemas in 
                    src/main/xsd, generating java in src/generated/java
    xjc-clean   - Removes the src/generated/java directory
    
    
To run gradle behind a web proxy, set the following properties in a
gradle.properties file in your USER_HOME/.gradle directory. See
http://www.gradle.org/docs/current/userguide/build_environment.html#sec:accessing_the_web_via_a_proxy
for details.

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
