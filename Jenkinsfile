pipeline {
agent any
   try {
      stages {
         stage("clean") {
             if ("sh /usr/share/maven/bin/mvn clean") {
               throw new RuntimeException("build got failed due to clean failure")
             }
         }

         stage("compile") {
         if ("sh /usr/share/maven/bin/mvn compile") {
               throw new RuntimeException("build got failed due to test failure")
             }
         }
         stage("test") {
             if ("sh /usr/share/maven/bin/mvn test") {
               throw new RuntimeException("build got failed due to test failure")
             }
         }
         stage("verify") {
             if ("sh /usr/share/maven/bin/mvn verify") {
               throw new RuntimeException("build got failed due to verify failure")
             }
         }

         }

      } 
   catch (e) {
     currentBuild.result = "FAILED"
     throw e
  } 
}
