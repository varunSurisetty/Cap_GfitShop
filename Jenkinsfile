pipeline {
    agent any
    stages {
    
        stage('clean') {
            steps {
               sh "/usr/share/maven/bin/mvn clean"
             } 
         } 
         
         post { 
        success { 
        
        stage('Build') {
            steps {
               sh "/usr/share/maven/bin/mvn compile"
             } 
             
             post { 
        success { 
        
        stage('Test') {
            steps {
               sh "/usr/share/maven/bin/mvn test"
             }
             post{success{stage('verify') {
            steps {
               sh "/usr/share/maven/bin/mvn verify"
            }
         }}}
         } 
        }
        
        }
             
         } 
        
        }
    }
        

        
        
     }
     
     
}


