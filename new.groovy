pipeline {
    agent any

    // Define parameters at the top level
    parameters {
        string(name: 'FIRST', defaultValue: '10', description: 'First number')
        string(name: 'SECOND', defaultValue: '20', description: 'Second number')
    }

    stages {
        stage('Run Normal Java Job') {
            steps {
                script {
                    echo 'Running non-parameterized Java job...'

                    // Path to the normal Java file
                    def javaFilePath = 'C:\\Users\\ARUSH_NILESH_NANCHE\\OneDrive\\Desktop\\New\\Main.java'

                    // Compile the Java file
                    bat "javac ${javaFilePath}"

                    // Run the Java program (Main class)
                    bat "java -cp "C:\Users\ARUSH_NILESH_NANCHE\OneDrive\Desktop\\New Main"
                }
            }
        }

        stage('Run Parameterized Java Job') {
            steps {
                script {
                    echo "Running parameterized Java job with parameters FIRST=${params.FIRST} and SECOND=${params.SECOND}"

                    // Path to the parameterized Java file
                    def javaFilePath = 'C:\\Users\\admin\\OneDrive\\Desktop\\jenkins\\Add.java'

                    // Compile the Java file
                    bat "javac ${javaFilePath}"

                    // Run the Java file with parameters
                    bat "java -cp C:\\Users\\admin\\OneDrive\\Desktop\\jenkins Add ${params.FIRST} ${params.SECOND}"
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
            // Optionally clean up compiled class files
            bat 'del C:\\Users\\admin\\OneDrive\\Desktop\\jenkins\\*.class'
        }
    }
}
