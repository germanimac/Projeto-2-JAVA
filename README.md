# Projeto-2-JAVA

### Foi proposto para os alunos, o trabalho de fazer um aplicativo e usar interação com microsserviços para jogar remotamente o trabalho-1 

#### o grupo composto por Marcelo Olmos e Gabriel Santini desenvolveu o projeto usando o android studios para o desenvolvimento do aplicativo e o net-beans para a realização dos microsserviços

**Sobre o Projeto:**
- O 2048 que esta sendo jogado é exatamente o mesmo que foi feito no trabalho 1
- Os microsserviços geram um servidor local com alguns caminhos que controlaram o movimento do jogo
- O aplicativo desenvolvido, possui botoes que serão os responsaveis por chamar o microsserviço.


**Detalhes do Projeto:**
- Quando um caminho (microsserviço) é chamado ele manda através de um socket qual é a direção que o jogo deve ir (direita, cima, esquerda, baixo)
- O servidor fica em loop, e espera que algo seja enviado para ele, atravésa porta 12345, e quando ele receber ele vai fazer a movimentação
- O aplicativo do jogo foi implementado completamente via Android Studios.

# O Aplicativo

<ul>
  <li>O aplicativo possui 4 classes que são responsaveis por fazer a chamada da URL nas direções propostas</li>
  <li>O aplicativo tambem possui uma Main que é a responsavel por fazer a chamada das funçoes de chamada de movimento</li>
  <li>O movimento é feito com 4 botões um para cada direção de movimento</li>
</ul>

# O Servidor

<ul>
  <li>O servidor é uma classe com a função getMsg que recebe o objeto contendo o jogo. Essa função fica em um loop onde ela cria um socket na porta 12345 e fica esperando algo ser enviado pela porta, ao receber a informação, ele percebe para qual a direção e sentido que as peças do jogo devem se mover e chama a função de update, descrita no readme do projeto-1.</li>
</ul>

# O Microserviço

<ul>
  <li>O microserviço possui quatro caminhos(URLs), um para cada direção e sentido (cima, baixo, esquerda,direita), que, ao serem acessadas, geram um socket e enviam a direção escolhida através da porta 12345, após isso, ele fecha o socket, para evitar problemas na abertura do socket.</li>
</ul>

# Instalação

<ul>
  <li>Baixe o release.</li>
  <li>Extraia o arquivo compactado que foi baixado.</li>
  <li>Abra a pasta extraida.</li>
  <li>Delete a pasta App.</li>
  <li>Extraia o arquivo compactado chamado App.</li>
  <li>Abra o Android Studio e execute o projeto App nele.</li>
  <li>Abra o NetBeans IDE 8.2.</li>
  <li>Abra os projetos Desenhar e Webserv no NetBeans.</li>
  <li>Aponte o caminho do arquivo java-json.rar (ele está na pasta junto com os projetos).</li>
  <li>Resolva o possivel problema de falta de servidor(é só mandar o netbeans baixar o glassfish server e selecionar ele como servidor).</li>
  <li>Execute ambos os projetos no NetBeans.</li>
  <li>Instale o aplicativo no seu dispositivo Android</li>
 
</ul>

### ATENÇÂO: o seu dispositivo Android e o computador onde o servidor e o jogo estão rodando devem estar na mesma rede wi-fi
### ATENÇÂO: o seu dispositivo Android precisa ser 9 ou superior
