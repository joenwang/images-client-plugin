grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: false,
    // configure settings for the run-app JVM
    run: false,
    // configure settings for the run-war JVM
    war: false,
    // configure settings for the Console UI JVM
    console: false
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }

    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        mavenLocal()
        mavenRepo ("http://nexus.ala.org.au/content/groups/public/") {
            updatePolicy 'always'
        }
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        // runtime 'mysql:mysql-connector-java:5.1.27'
        compile('org.codehaus.groovy.modules.http-builder:http-builder:0.7') {
            excludes "commons-logging", "xml-apis", "groovy"
        }
    }

    plugins {
        build(":release:3.0.1",
              ":rest-client-builder:1.0.3") {
            export = false
        }
        compile ':ala-auth:1.3.4'
        runtime ':font-awesome-resources:4.3.0.1'
    }
}
