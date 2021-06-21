pipeline {
    agent any
    stages {
        stage('clean') {
            steps {
               sh "/usr/share/maven/bin/mvn clean"
             } 
         }  
        stage('verify') {
            steps {
               sh "/usr/share/maven/bin/mvn verify -Dv=${BUILD_NUMBER}"
            }
         }
       }
}