pipeline {
    agent any

    parameters {
        string(name: 'MOT', description: 'Le mot qui sera affiche')
        string(name: 'NOMBRE', description: 'Le nombre de fois que ce mot sera affiche')
    }

    stages {
        stage('Clonage git') {
            steps {   
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/Treldyr/jenkins_files.git']]])
                sh "/bin/python3 .github/workflows/countWordsProgram.py ${params.NOMBRE}--${params.MOT}"
                
            }
        }
    }
}
