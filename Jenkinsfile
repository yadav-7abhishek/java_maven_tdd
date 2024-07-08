node {
    // Define the pom.xml
    def mvnFile = "pom.xml"

    // Checkout from SCM
    stage ("Checkout") {
        checkout scm
    }
  
    // Compile
    stage ("Compile") { 
        sh "rm -rf ~/.m2/repository/com/alacritysys"
        sh "mvn -f ${mvnFile} clean compile"
    }

    // Quality check
    stage ("Quality") { 
        sh "mvn -f ${mvnFile} verify sonar:sonar"
    }

    // Install or deploy depending on the branch
    stage ("Publish") { 
        sh "mvn -f ${mvnFile} deploy -DskipTests -DdetectLinks -Dshow=package" 
    }
}