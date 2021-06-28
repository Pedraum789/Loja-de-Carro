# Loja-de-Carro

# Proposta:
O intuito deste exercício é validar o máximo de conhecimento que você possui.

Antes de mais nada, crie um repositório no git e cole o conteúdo desse texto no readme.

Você precisará construir um sistema para uma agência de veículos, ele será composto por uma api e um frontend (Desktop ou Mobile).

Sinta-se à vontade para usar a linguagem que achar melhor e pode usar templates prontos, frameworks e/ou outras coisas que possam facilitar a sua vida.

Crie um arquivo readme falando um pouco sobre quais as decisões que você tomou para a resolução do exercício, e, caso não tenha feito algo, explique o motivo. Também informe os passos para fazer sua aplicação rodar, e caso tenha, o processo de deploy.

Precisamos que nosso sistema seja capaz de:

- Cadastrar a compra de um veículo, modelo, marca, ano de fabricação, placa, cor, chassi, data da compra e valor da compra.

- Registrar a venda de um veículo, com data da venda, valor da venda e comissão do vendedor (10% sobre o lucro da venda).

- Deverá ser possível listar todos os veículos, veículos disponíveis e histórico de veículos vendidos.

- Listar o valor total em compras e vendas, lucro/prejuízo do mês e o valor pago em comissões.

Caso queira criar mais funcionalidades fique à vontade, apenas se lembre de mencionar sobre elas no readme.

Qualquer dúvida entre em contato comigo pelo linkedin, estarei à disposição para esclarecer quaisquer dúvidas que surgirem.

Ao finalizar a prova basta enviar o link do repositório no linkedin.

## Linguagem

### Tomei a decisão de programar o exercício em Java, pois achei que seria mais apropriado e teria mais conhecimento, ja que me dou bem com a linguagem.
### Utilizei a IDE Netbeans 12.0
![netbeans](https://user-images.githubusercontent.com/35739467/123696391-178ccd00-d832-11eb-8925-9ed2fe074784.png)


# Banco de dados PostgreSQl

### Além da linguagem Java, utilizei o banco de dados PostgreSQL, pois por hora é o banco que mais sei utilizar.

### Fiz a criação de duas tabelas no banco, uma chamada: "cadastracompra" 
![cadastracompra](https://user-images.githubusercontent.com/35739467/123695909-84539780-d831-11eb-946f-d6ec1d7d903a.png)
### Outra como :"registravenda".
![registravenda](https://user-images.githubusercontent.com/35739467/123695913-8584c480-d831-11eb-99fd-7b3de0a4e4bd.png)

### Todos os dados que obter dentro da API, irá diretamente para o banco de dados.

# Java

### Foi criado 5 telas pelo JFrame (utilizei o JFrame, pois acredito que seja a mais simplês de se usar para o Front-end).
### A Tela inicial:
![telainicial](https://user-images.githubusercontent.com/35739467/123697139-ef519e00-d832-11eb-9a7d-829a40be5d84.png)
#### Onde é possível escolher uma das 4 opções ou simplêsmente fechar o programa.

### Tela de Cadastrar o Veículo:
![cadastrar](https://user-images.githubusercontent.com/35739467/123697341-2d4ec200-d833-11eb-9d43-2100149ff979.png)
#### Nessa tela é onde você pode fazer o cadastro de seus carros, como mostrado na tela, quando completar, basta clicar em cadastrar
#### Caso tudo esteja correto, irá aparecer a imagem:
![sucesso](https://user-images.githubusercontent.com/35739467/123697589-76067b00-d833-11eb-876f-cd6cdcab511a.png)

### Tela de Registrar Venda:
![registra](https://user-images.githubusercontent.com/35739467/123697696-95050d00-d833-11eb-974d-0e66f840e32f.png)
#### Nessa tela você pode registrar uma venda, assim ele já irá calcular a comissão e o lucro.

### Tela de Listar Veículos:
![listarveic](https://user-images.githubusercontent.com/35739467/123698304-6a678400-d834-11eb-9d7d-2a79efbe3bee.png)
#### Podemos ver todos os veículos vendidos e disponíveis para venda (coloquei alguns dados no banco para testar e ilustrar). 

### Tela de Listar Valores
![listarvalor](https://user-images.githubusercontent.com/35739467/123700118-6ccadd80-d836-11eb-971d-4924ff527268.png)
#### Lista o valor total de compras, vendas, lucro e comissões.

# Passos dados para a criação:

### Primeiramente fiz as telas no JFrame, pois é a execução mais rápida do projeto.
### Logo após as criação do pacote view, que é onde irá ficar todas as telas, criei todos os outros pacotes que fazem parte do MVC.
### Depois fui fazendo em ordem dos tópicos para a relização do back-end.
### Após finalizar, fiz alguns ajustes pequenos para os erros de execução e finalizei o projeto.

# Aplicação

## Para fazer a aplicação funcionar, basta instalar os arquivos, abrir a pasta "dist" e executar o arquivo jar "Loja_Carro"
