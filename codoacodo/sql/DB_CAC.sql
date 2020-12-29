insert into comentarios(comment, quality, id_usuario, id_producto)
values
("que buen producto, lo recomiendo", 4.7, 
(select id_usuario from usuarios where id_usuario=2), 
(select id_producto from productos where id_producto=9));

insert into comentarios(comment, quality, id_usuario, id_producto)
values
("que buen producto, lo recomiendo", 4.7, 
4, 
5);

select * from usuarios;
select * from comentarios;
select * from productos;

select * from comentarios where id_producto = 9;

select * from usuarios where id_usuario = 2;
select * from productos where id_producto = 5;

select * from usuarios where email = "user1@hotmail.com" and password = "1234";


SELECT 
    *
FROM
    comentarios 
        natural JOIN
    usuarios
WHERE
    id_producto = 5;

SELECT * FROM comentarios as c inner join usuarios as u on u.id_usuario = c.id_usuario ;

SELECT 
    id_usuario, comment, c.quality
FROM
    productos as p
        INNER JOIN
    comentarios as c ON c.id_producto = p.id_producto
WHERE
    p.id_producto = 13;
    
select * from productos join comentarios;

SELECT 
   *
FROM
    productos AS p
        right JOIN
    comentarios AS c ON c.id_producto = p.id_producto
    where p.id_producto is not null;