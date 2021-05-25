pipeline {
    agent any
    stages {
        stage('clean') {
            steps {
               sh "/usr/share/maven/bin/mvn clean"
             } 
         } 
        stage('Build') {
            steps {
               sh "/usr/share/maven/bin/mvn compile"
             } 
         } 

        stage('Test') {
            steps {
               sh "/usr/share/maven/bin/mvn test"
             }
         } 
        stage('verify') {
            steps {
               sh "/usr/share/maven/bin/mvn verify"
            }
         }
     }
}


