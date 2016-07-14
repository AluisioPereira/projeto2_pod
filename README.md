2º PROJETO POD 2016.1 - ADS-Cajazeiras.

FLUXO DE TRABALHO A SER SEGUIDO

1- clone esse repositório

git clone https://github.com/AluisioPereira/projeto2_pod.git

2- Na pasta raiz do projeto, crie e cheque sua branch

git checkout -b bNOME_DA_SUA_BRANCH

3- Mescle as outras branchs com a sua branch para que sua branch receba mudanças dos outros colaboradores:

git merge origin/bJOE

git merge origin/bLAERTON

4- Faça um push da sua branch

git push origin bNOME_DA_SUA_BRANCH

5- Antes de implementar alguma funcionalidade, verifique as outras branchs possuem atualizações

git pull origin bJOE

git pull origin bLAERTON

6- Caso existam atualizações, novamente mescle as outras branchs a sua branch

git merge origin/bJOE

git merge origin/bLAERTON

7- Finalmente faça suas alterações e então comite e faça push

git add .

git commit -m "mensagem de commit"

git push origin bNOME_DA_SUA_BRANCH

8- Sempre repita os passos 5 e 6 antes de realizar mudanças. Isso ajuda a evitar conflitos

-->

