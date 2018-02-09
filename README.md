# projetoProgWeb
📖 Open-source  📦 Java Web, XHTML e CSS 🔧 Trabalho desenvolvido ao longo do semestre na disciplina

## Finalidade
- Nano sistema financeiro que oferece cadastro de clientes e controle de faturas para cada cliente. A quitação de uma fatura parcial gera uma nova com o valor restante a ser pago e configurações atualizadas.
- Administração básica do crediário da loja familiar de um dos membros do projeto: @leonardojcmay
- A loja apenas fornece a opção de crediário aos clientes confiáveis e que possuem histórica de boas relações com a marca.
- O controle é realizado de forma básica, o sistema é vital apenas para um histórico de pagamentos/gastos pelos clientes cadastrados.
- Aceita personalização da interface de forma básica (alteração de logomarca).

## Leia-me antes de usar
- Clone SEMPRE a última versão do branch "master", para garantir que a versão do código esteja atualizada corretamente.
- Por se tratar de um protótipo, há algumas páginas que não possui utilidade vital para o funcionamento do projeto, as mesmas foram mantidas apenas para implementações futuras.
- Há também uma modelagem mais avançada na parte de banco de dados, toda pensada também para futuras implementações.
- A utilização será apenas localhost e por um único usuário, sendo assim é necessário acessar a tabela **usuario** e cadastrar o registro esperado para realizar login.

### Clonar repositório para teste
- O nome do projeto é o mesmo do repositório (projetoProgWeb).
- Clone o repositório no workspace do Eclipse. Importe o projeto na IDE e realize os testes. (Se preferir faça download do .zip diretamente no Github e importe manualmente).
- O banco de dados está disponível remotamente, porém na Unisul há momentos em que o mesmo não acessa devido a questões de firewall.
- Verificar o atributo **validate**; **create** no arquivo <a href="https://github.com/tiagoboeing/projetoProgWeb/blob/master/src/main/resources/hibernate.cfg.xml">hibernate.cfg</a>

### Upload de imagem do sistema
- O upload só funcionará se for configurado o caminho/pasta para que upload seja realizado. Evitando a necessidade de atualizar o projeto no Eclipse manualmente, escolhemos um caminho local no **desktop** do sistema. 
- A alteração deve ser realizada no arquivo <a href="https://github.com/tiagoboeing/projetoProgWeb/blob/master/src/main/java/br/unisul/projeto/bean/SistemaBack.java">SistemaBack.java</a> (linha 76). 

## Executar projeto
>O arquivo a ser rodado é o <a href="https://github.com/tiagoboeing/projetoProgWeb/blob/master/src/main/webapp/root/principal.xhtml">**principal.xhtml**</a> ou <a href="https://github.com/tiagoboeing/projetoProgWeb/blob/master/src/main/webapp/root/login.xhtml">**login.xhtml**</a>

# Dúvidas?
- Tiago Boeing: (48) 99168-0027 | contato@tiagoboeing.com.br | tiagoboeing11@gmail.com
- Leonardo May: (48) 99941-9284 | leojcmay@gmail.com
