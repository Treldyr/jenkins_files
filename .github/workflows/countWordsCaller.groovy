pipeline {
    agent any

    stages {

        stage('Clonage git') {
            steps {
                
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/Treldyr/jenkins_files.git']]])

                sh '''
                    /bin/python3 .github/workflows/countWordsCaller.py 3--bamboo
                '''
            }
        }

    }
}
