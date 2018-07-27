insert into ingrediente (ingrediente_id, nome) values (1, 'Ingrediente 1');
insert into ingrediente (ingrediente_id, nome) values (2, 'Ingrediente 2');
insert into ingrediente (ingrediente_id, nome) values (3, 'Ingrediente 3');

insert into categoria (categoria_id, nome) values (1, 'Categoria 1');
insert into categoria (categoria_id, nome) values (2, 'Categoria 2');
insert into categoria (categoria_id, nome) values (3, 'Categoria 3');

insert into produto (produto_id, codigo, nome, preco, categoria_id) values (1, '1234', 'Produto 1', 10.50, 1);
insert into produto (produto_id, codigo, nome, preco, categoria_id) values (2, '5678', 'Produto 2', 11.50, 2);
insert into produto (produto_id, codigo, nome, preco, categoria_id) values (3, '9101', 'Produto 3', 12.50, 3);

insert into produto_ingrediente (produto_id, ingrediente_id) values (1, 1);
insert into produto_ingrediente (produto_id, ingrediente_id) values (1, 2);
insert into produto_ingrediente (produto_id, ingrediente_id) values (1, 3);
insert into produto_ingrediente (produto_id, ingrediente_id) values (2, 1);
insert into produto_ingrediente (produto_id, ingrediente_id) values (3, 1);
insert into produto_ingrediente (produto_id, ingrediente_id) values (3, 3);

insert into pessoa (tipo, pessoa_id, nome) values ('Cliente', 1, 'Cliente 1');
insert into pessoa (tipo, pessoa_id, nome) values ('Cliente', 2, 'Cliente 2');

insert into cliente (pessoa_id, telefone) values (1, 87874545);
insert into cliente (pessoa_id, telefone) values (2, 98896666);