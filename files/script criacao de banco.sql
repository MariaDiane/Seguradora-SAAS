create schema seguros_saas;
/*drop schema seguros_saas;*/

use seguros_saas;

CREATE TABLE `loja` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) DEFAULT NULL,
  `razao_social` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `valor` double NOT NULL,
  `loja_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKst05r29lf95fc2rnp5q9ln9v` (`loja_id`),
  CONSTRAINT `FKst05r29lf95fc2rnp5q9ln9v` FOREIGN KEY (`loja_id`) REFERENCES `loja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `segurado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `estado_civil` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `contrato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_criacao` datetime DEFAULT NULL,
  `fim_vigencia` datetime DEFAULT NULL,
  `forma_pagamento` varchar(255) DEFAULT NULL,
  `inicio_vigencia` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `loja_id` bigint(20) DEFAULT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  `segurado_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi5imhjotp2qu0klt4efv0gomm` (`loja_id`),
  KEY `FKccn25bgymhfnuly4fx26ex7eo` (`produto_id`),
  KEY `FK9tsacmjwa70gqhplpvat8n3gs` (`segurado_id`),
  CONSTRAINT `FK9tsacmjwa70gqhplpvat8n3gs` FOREIGN KEY (`segurado_id`) REFERENCES `segurado` (`id`),
  CONSTRAINT `FKccn25bgymhfnuly4fx26ex7eo` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `FKi5imhjotp2qu0klt4efv0gomm` FOREIGN KEY (`loja_id`) REFERENCES `loja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*insere as lojas*/
insert into loja values (1,'123.123.123/09', 'Magazine Luiza', 'magluiza', '123456'), (2,'321.321.321/13', 'Pósitron', 'positron', '123456'), (3,'532.263.432/03', 'Ituran', 'ituran', '123456'), (4,'745.463.523/39', 'Tesb', 'tesb', '123456'), (5,'235.123.123/04', 'Cetelem', 'cetelem', '123456'), (6,'935.263.645/45', 'Renault', 'renault', '123456');

/*insere os produtos*/
insert into produto values (1, 'Pósitron Autofácil', 130, 2), (2, 'Tesb com assitência', 130, 4), (3, 'Tesb sem assitência', 130, 4), (4, 'Ituran com seguro', 130, 3), (5, 'Seguro luiza roubo e furto', 130, 1), (6, 'Seguro luiza vida', 130, 1), (7, 'Seguro luiza residencial', 130, 1), (8, 'Renault seguro', 130, 6), (9, 'Cetelem telhanorte residencial', 130, 5);

/*insere segurados*/
insert into segurado values (1, '344.432.123-56', '1985-10-22', 'solteiro', 'Júlio Oliveira da Silva'), (2, '144.132.423-46', '1983-05-13', 'casado', 'Vinicius'), (3, '152.834.374-60', '1995-06-03', 'casada', 'Helena Strada'), (4, '200.123.948-60', '1984-02-01', 'casado', 'Diego');

/*insere contrato*/
insert into contrato values (1, '2017-07-03', '2018-08-10', 'cartão parcelado', '2017-08-10', '201700000010', 3, 4, 1, 'Ativo'), (2, '2017-09-13', '2018-10-01', 'boleto bancario', '2017-10-01', '41230000001', 1, 5, 4, 'Pendente'), (3, '2017-06-01', '2018-06-15', 'cartão a vista', '2017-06-15', '41230000001', 1, 6, 3, 'Cancelado');