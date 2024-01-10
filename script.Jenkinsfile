pipeline{
	agent any	

	tools{
		maven "MAVEN_HOME"
	}
	stages{
	    stage('Installing Maven Tool')
		{
		    steps
			{
				echo 'Maven tool Installed successfully'
			}
		}
		stage('Fetch Code From GitHub')
		{
		    steps
			{
				git credentialsId: '3f6b82cc-8818-4739-aede-6cb12b08144c', url: 'https://github.com/KrunalAplombsoft/SeleniumTestNGFramework.git'
			}
		}
		stage('Execute TestNG TestCases')
		{
		    steps
			{
				bat 'mvn clean install -DsuiteFile=${XMLFileName}.xml'
			}
		}
	}
}