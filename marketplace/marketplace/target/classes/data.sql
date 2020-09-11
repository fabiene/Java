insert into usuario (id, nome_cliente, nick_name, cpf, email, data_nascimento, cep, rua, numero, bairro, cidade, estado, ddd,  telefone, tipo) values
	(1,'Fabiene Avilla', 'fabiene','023.367.569-72', 'fabiene.avilla@gmail.com', parsedatetime('1980-01-10', 'yyyy-mm-dd'), '25675-160','Bataillard', 1253, 'Mosela', 'Petrópolis', 'RJ', '(24)', '2245-5865', 'fixo'),
	(2,'Wecsisley Jesus', 'wecsisley','111.111.111-11', 'teste001@gmail.com', parsedatetime('1985-03-12', 'yyyy-mm-dd'),'25678-132','Rua das Flores',  123, 'Centro', 'Petrópolis', 'RJ','(24)', '2221-3258', 'fixo'),
	(3,'Thayná de Oliveira', 'thayná','222.222.222-22', 'teste002@gmail.com', parsedatetime('19891-04-16', 'yyyy-mm-dd'),'25645-705','Rua Pedras Brancas', 179, 'Mosela', 'Petrópolis', 'RJ','(21)', '99921-5678', 'celular');



insert into categoria (id, nome_categoria, descricao_categoria) values
	(1, 'alimentos', 'produtos alimentícios em geral'),
	(2, 'bebidas', 'bebidas alcoolicas e não alcoolicas'),
	(3, 'eletrônicos', 'eletrodomésticos, celulares e outros');
	
	
insert into produto (id, nome_produto, desc_Prod, nome_vendedor, valor_Unit, qtd_Prod, data_Fabric, usuario_id, categoria_id) values
	(1, 'Leite Integral', '1 litro Parmalat', 'Wecsisley Jesus', 4.95, 100, parsedatetime('2020-07-24', 'yyyy-mm-dd'),1, 1),
	(2, 'Coca Cola', '2 litros','Fabiene Avilla', 6.99, 100, parsedatetime('2020-06-24', 'yyyy-mm-dd'), 2, 2),
	(3, 'Papel Toalha', 'Snob', 'Thayná Oliveira', 4.99, 100, parsedatetime('2020-04-24', 'yyyy-mm-dd'), 3, 3);

	

insert into pedido_compra (id, data, usuario_id) values
	(1, parsedatetime('2020-08-24', 'yyyy-mm-dd'),1),
	(2, parsedatetime('2020-08-23', 'yyyy-mm-dd'),2),
	(3, parsedatetime('2020-08-22', 'yyyy-mm-dd'),3);
	
insert into item (id, qtd_item, produto_id, pedido_compra_id) values
	(1, 1, 1, 1),
	(2, 1, 2, 2),
	(3, 1, 3, 3);

	


