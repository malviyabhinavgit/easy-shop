node{

stage ('Checkout SCM'){
    git 'https://github.com/malviyabhinavgit/easy-shop.git'
}
		stage ('Compile Package'){
    sh 'mvn clean install'
}
}
