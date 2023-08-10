# Farmacia da Rural

## Integrantes do grupo
* Rodrigo Albuquerque da Costa - roro.costa2018@gmail.com
* Alan da Costa Pessoa - alanpessoa1387@gmail.com
* Rafael Rodrigues Martins da Silva - rafamartins.4d@gmail.com
* Pedro Henrique Rodrigues da Silva - pedrohrsilva280@gmail.com
* José Fernando Carvalho de Oliveira - josefernando354@gmail.com

## Descrição geral do projeto
    O projeto trata-se da implementação de um sistema para gerenciar uma farmácia 

 1. Quem ira utilizar a nossa aplicação?
   * Funcionários da farmácia que utilize o nosso sistema;
    
 2. Que serviços são “necessários” (leia-se: importantes para os clientes e usuários)?
   * A farmácia deve ser capaz de exibir uma lista com seus produtos e a quantidade disponível para cada produto junto com seu preço, além de ser capaz de abastecer seu estoque e listar clientes e funcionários de acordo com parâmetros pré-definidos.
    
 3. Quais serviços cada usuário pode executar?
   * Usuários do tipo Funcionario devem ser capaz de abastecer o estoque da farmácia e vender produtos da mesma, enquanto, usuários do tipo Cliente devem ser capaz apenas de comprar produtos da farmácia.

## Requisitos do projeto

* ** REQ1 ** - O sistema deve ser capaz de armazenar valores que representem os clientes e funcionários da farmácia;
* ** REQ2 ** - O sistema deve ser capaz de armazenar valores que representem os produtos da farmácia;
* ** REQ3 ** - O sistema deve ser capaz de armazenar valores que representem as vendas da farmácia;
* ** REQ4 ** - O sistema deve ser capaz de cadastrar e remover Produtos verificando se o produto a ser cadastrado ou removido já está cadastrado no sistema;
* ** REQ5 ** - O sistema deve ser capaz de cadastrar e remover Funcionários e Clientes verificando se os mesmos já não estão cadastrados;
* ** REQ6 ** -  O sistema deve ser capaz de exibir relatórios de vendas, mostrando informações como produtos em baixo estoque, vendas por data, etc;
* ** REQ7 ** - O metodo para listar vendas por datas deve receber dois parâmetros do tipo LocalDateTime. um representando a data inicial e outro a data final e retornar um ArrayList com todas as vendas que possuem data entre o periodo inicial/final passados como parâmetros armazenadas no repositorio de vendas;
* ** REQ8 ** - O sistema deve implementar um mecanismo listar: Clientes cadastrados, Funcionarios da farmácia, 3 funcionários que mais venderam, 3 clientes que mais compraram;
* ** REQ9 ** -  Deve haver uma metodo para venda de produtos que recebe como parâmetros um funcionário, um cliente e um ArrayList contendo os produtos a serem vendidos. Este método deve verificar se o funcionario e o cliente passados como parâmetro estão cadastrados e caso estejam, calcular o valor da venda e instanciar um objeto do tipo Venda posteriormente armazenando-o em um Repositório de vendas;
* ** REQ10 ** - Garantir que o estoque possa ser abastecido e que o estoque de produtos nunca fique negativo, verificando a disponibilidade de produtos antes de realizar uma venda;
* ** REQ11 ** - O sistema deve calcular o valor total da compra do cliente e gerar um comprovante de compra;
* ** REQ12 ** - Deverá haver um controlador (ou gerenciador) responsável por intermediar as interações entre a interface gráfica, os repositórios de funcionários, clientes e produtos, e as classes de negócio (Funcionário, Cliente, Produto). O controlador será responsável por processar as solicitações do usuário, atualizar os repositórios conforme necessário e fornecer informações para a interface gráfica exibir ao usuário;
* ** REQ13 ** - A interface gráfica deve ser implementada utilizando uma biblioteca gráfica apropriada em Java, como Swing ou JavaFX. Ela deverá fornecer uma experiência intuitiva para os usuários interagirem com o sistema de gerenciamento de farmácia. A interface gráfica deve permitir a navegação entre as diferentes funcionalidades do sistema, como cadastro de funcionários, cadastro de clientes, cadastro de produtos, venda de produtos, relatórios, etc;
* ** REQ14 ** - A interface gráfica deve fornecer mensagens claras e informativas para orientar os usuários em caso de erros ou ações bem-sucedidas. Por exemplo, em casos de tentativa de venda de um produto indisponível no estoque ou sucesso no cadastro de um novo funcionário;

## Cronograma de MVPs com seleção de requisitos

* *MVP1 - cadastros* - [REQ5, REQ9]: cadastro básico das entidades do sistema. Essa funcionalidade se faz necessária, pois a farmácia necessita cadastrar os produtos que serão vendidos os funcionários que os venderão e os clientes que comprarão;
* *MVP2 - remoções* - [REQ5, REQ9]: descadastrar entidades do sistema. Essa funcionalidade se faz necessária, pois em algum momento será necessário remover alguma entidade básica previamente cadastrada do sistema, como, por exemplo, um produto que já não é mais vendido na farmácia;
* *MVP3 - vendas* - [REQ4]: Implementação de regras para realização de vendas de produtos controlados(com tarja) e comuns. Essa funcionalidade se faz necessária, pois é preciso que os medicamentos sejam vendidos de maneira correta impedindo a compra indevida de medicamentos por clientes não autorizados; 
* *MVP4 - estoque* - [REQ10]: Implementação de regras para a atualização do estoque e impedir que ele fique negativo. Essa funcionalidade se faz necessária, para garantir que a farmácia possua produtos para vender;
