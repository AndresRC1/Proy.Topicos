create database taqueria;

use taqueria;

Create table empleado(
id_empleado int primary key,
nombre_empleado varchar(50) not null,
telefono varchar(12) not null,
direccion varchar(50) not null,
usuario varchar(50) not null,
pass varchar(32) not null);

Create table categoria_producto(
id_categoria int primary key,
categoria varchar (50) not null);

Create table proveedor(
id_proveedor int primary key,
nombre_proveedor varchar(50),
teléfono varchar(40),
dirección varchar(50));

Create table producto(
id_producto int primary key,
nombre_producto varchar(50) not null,
descripcion varchar(50) not null,
cantidad int not null,
precio numeric(9,2),
id_proveedor int not null,
id_categoria int not null,
constraint productoFK1 foreign key (id_proveedor) references proveedor(id_proveedor),
constraint productoFK2 foreign key (id_categoria) references categoria_producto(id_categoria));

Create table orden(
id_orden int not null,
nota varchar (150),
constraint ordenPK primary key (id_orden));

Create table compra(
id_compra int not null,
fecha date not null,
id_empleado int not null,
constraint compraPK primary key (id_compra),
constraint compraFk1 foreign key (id_empleado) references empleado(id_empleado));

create table compra_detalle(
id_compra int not null,
id_orden int not null,
id_producto int not null,
cantidad int not null,
precio_unitario int not null,
constraint compra_detallePk primary key (id_compra, id_orden),
constraint compra_detalleFk1 foreign key (id_compra) references compra(id_compra),
constraint compra_detalleFk2 foreign key (id_orden) references orden(id_orden),
constraint compra_detalleFk3 foreign key (id_producto) references producto(id_producto));

