# seguros-saas

O seguros-saas é um projeto que consiste em disponibilizar um serviço saas para que as lojas de seguros realizem o cadastro de novos contratos e que possam listar esses contratos.
O projeto expõe duas APIs RestFul, uma para cadastro de novos contratos de seguro e outra para listagem.
Há tambem um módulo web que lista os contratos por loja.

## Problema Identificado

Atualmente cada loja tem seu próprio sistema de seguro, se preocupando com o desenvolvimento e manutenção de uma aplicação para o seu negócio.

## Solução Proposta

Propomos desenvolver um sistema onde cada loja manterá somente os seus próprios dados. 
De maneira que, possa cadastrar seus próprios produtos, mantenha seus próprios contratos e segurados.

## Detalhes do projeto

Utilizamos o conceito de multi tenancy para atender as diferentes empresas sem que os dados sejam compartilhados entre elas.
No desenvolvimento foi utilizado SpringBoot para expor as APIs RestFul, para realizar o cadastro de novos contratos.
No módulo Web, utilizado para a listagem dos contratos, utilizamos o Thymeleaf com HTML, CSS e um template em Bootstrap.

![alt tag](https://raw.githubusercontent.com/juliodasilv/seguros-saas/master/files/architecture_diagram.png)

A  arquitetura se apresenta da seguinte maneira. 
As APIs RestFul são utilizadas para efetuar novos cadastros e a parte web para listagem desses cadastros. 
Todos estão instalados em containers diferentes do docker. O banco de dados (MySQL) está separado das aplicações, tambem em um container.
Como ferramentas para integração continua, estamos utilizando Git, Maven e Jenkins.

### Diagrama MER

![alt tag](https://raw.githubusercontent.com/juliodasilv/seguros-saas/master/files/mer.png)

A ideia do projeto é disponibilizar um serviço como SaaS e dentre as alternativas presentes de multitenancy, disponibilizamos a solução em que é criado um id para cada loja, dividindo e identificando assim todos os seus registros pertencentes.

## Instalação (em breve)

## utilização

Uma vez instalado, para acessar a aplicação basta utilizar os links a seguir:

a. WEB: http://192.168.200.100:8081/
b. API para cadastro de produtos:
i. http://192.168.200.100:8082/add
ii. http://192.168.200.100:8082/buscar
c. API para efetuar Venda de seguros:
i. http://192.168.200.100:8083/add
ii. http://192.168.200.100:8083/buscar
d. Banco:
i. 192.168.200.100:3306
ii. user: root
iii. pass:root

## Resumo das tecnologias utilizadas

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework Web usado
* [Spring Data](https://spring.io/projects/spring-data) - Framework para auxiliar na persistencia dos dados
* [Maven](https://maven.apache.org/) - Gerenciador de dependencias
* [Jenkins](https://jenkins.io/) - Ferramenta para auxiliar na integração contínua.
* [Docker](https://www.docker.com/) - Gerenciador de containers.
* [MySQL](https://www.mysql.com/) - Banco de dados relacional.

## Autor

* **Julio Oliveira da Silva** - [juliodasilv](https://github.com/juliodasilv)
* **Helena Strada** - [hstrada](https://github.com/hstrada)
* **Vinícius Rigo** - [vrigosilva](https://github.com/vrigosilva)
