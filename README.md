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
    Funcionários e possíveis clientes da farmácia que utilize o nosso sistema;
    
 2. Que serviços são “necessários” (leia-se: importantes para os clientes e usuários)?
    A farmácia deve ser capaz de exibir uma lista com seus produtos e a quantidade disponível para cada produto junto com seu preço, além de ser capaz de abastecer seu estoque e listar clientes e funcionários de acordo com parâmetros pré-definidos.
    
 3. Quais serviços cada usuário pode executar?
    Usuários do tipo Funcionario devem ser capaz de abastecer o estoque da farmácia e vender produtos da mesma, enquanto, usuários do tipo Cliente devem ser capaz apenas de comprar produtos da farmácia.

## Requisitos do projeto

* ** REQ1 ** - Deverá haver uma classe abstrata chamada Pessoa e duas classes filha da classe Pessoa são elas: Funcionario e Cliente;
* ** REQ2 ** - Deverá haver uma classe abstrata chamada Produto e duas classes filha da classe Produto são elas: Comum e TarjaPreta;
* ** REQ3 ** - Deverá haver um único repositório para armazenar os funcionarios e clientes da farmácia;
* ** REQ4 ** - Deverá haver um único repositório para armazenar os produtos de ambos os tipos da farmácia;
* ** REQ5 ** - Cada produto deve ter um código único, nome, preço, quantidade em estoque e informações específicas para medicamentos tarja preta (como tarja, posologia, princípio ativo, etc.);
* ** REQ6 ** - Os funcionários devem poder realizar ações de venda, inserindo o código do produto e a quantidade a ser vendida. O sistema deve calcular o valor total da compra e atualizar o estoque de produtos;
* ** REQ7 ** - A classe do tipo RepositorioProdutos deve implementar um mecanismo para que o sistema possa exibir relatórios de vendas, mostrando informações como produtos mais vendidos, produtos em baixo estoque, vendas por data, etc;
* ** REQ8 ** - A classe do tipo RepositorioProdutos deve ser capaz de cadastrar e remover Produtos verificando se o produto a ser cadastrado ou removido é cadastrado no repositório;
* ** REQ9 ** - A classe do tipo RepositorioPessoas deve implementar um mecanismo para que o sistema possa listar: Clientes cadastrados, Funcionarios da farmácia, 3 funcionários que mais venderam em um determinado periodo, 3 clientes que mais compraram em um determinado periodo;
* ** REQ10 ** - A classe do tipo RepositorioPessoas deve ser capaz de cadastrar e remover Funcionários e Clientes verificando se os mesmos já não estão cadastrados;
* ** REQ11 ** - Garantir que o acesso a certas funcionalidades seja restrito a funcionários;
* ** REQ12 ** - Garantir que o estoque de produtos nunca fique negativo, verificando a disponibilidade de produtos antes de realizar uma venda;
* ** REQ13 ** - O sistema deve calcular o valor total da compra do cliente e gerar um comprovante de compra;
* ** REQ14 ** - Deverá haver um controlador (ou gerenciador) responsável por intermediar as interações entre a interface gráfica, os repositórios de funcionários, clientes e produtos, e as classes de negócio (Funcionário, Cliente, Produto). O controlador será responsável por processar as solicitações do usuário, atualizar os repositórios conforme necessário e fornecer informações para a interface gráfica exibir ao usuário;
* ** REQ15 ** - A interface gráfica deve ser implementada utilizando uma biblioteca gráfica apropriada em Java, como Swing ou JavaFX. Ela deverá fornecer uma experiência intuitiva para os usuários interagirem com o sistema de gerenciamento de farmácia. A interface gráfica deve permitir a navegação entre as diferentes funcionalidades do sistema, como cadastro de funcionários, cadastro de clientes, cadastro de produtos, venda de produtos, relatórios, etc;
* ** REQ16 ** - A interface gráfica deve fornecer mensagens claras e informativas para orientar os usuários em caso de erros ou ações bem-sucedidas. Por exemplo, em casos de tentativa de venda de um produto indisponível no estoque ou sucesso no cadastro de um novo funcionário;
