pipeline 
{
    agent any
      stages 
      {
         stage("clean") {
            try{
             if ("sh /usr/share/maven/bin/mvn clean") {
               throw new RuntimeException("build got failed due to clean failure")
             }
         }catch (e) {
     currentBuild.result = "FAILED"
     throw e}
         }

         stage("compile") {
            try{
         if ("sh /usr/share/maven/bin/mvn compile") {
               throw new RuntimeException("build got failed due to test failure")
             }
         }catch (e) {
     currentBuild.result = "FAILED"
     throw e}
     }
         stage("test") {
            try{
             if ("sh /usr/share/maven/bin/mvn test") {
               throw new RuntimeException("build got failed due to test failure")
             }
         }catch (e) {
     currentBuild.result = "FAILED"
     throw e}
         stage("verify") {
             try{
                if ("sh /usr/share/maven/bin/mvn verify") {
               throw new RuntimeException("build got failed due to verify failure")
             }}catch (e) {
     currentBuild.result = "FAILED"
     throw e}
         }

        }

    } 
