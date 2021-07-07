CREATE DATABASE `bdBANCO`;
use bdBanco;

CREATE TABLE `Roles`
(
`IdRol` int NOT NULL ,
`Descripcion` varchar(45) NOT NULL,
PRIMARY KEY (`IdRol`)
);

CREATE TABLE `Usuarios`
(
`IdUsuario` int NOT NULL AUTO_INCREMENT,
`Dni` int NOT NULL ,
`Cuil` varchar(20) ,
`Genero` varchar(15) NULL,
`Nacionalidad` varchar(45) NULL,
`F_Nacimiento` date NOT NULL, /*AAAA-MM-DD*/
`Direccion` varchar(45) NULL,
`Localidad` varchar(45) NULL,
`Provincia` varchar(45) NULL,
`Telefono` varchar(45) NULL,
`NombreUsuario` varchar(45) NOT NULL,
`Nombre` varchar(45) NULL,
`Apellido` varchar(45) NULL,
`Email` varchar(75) NOT NULL,
`Password` varchar(45) NOT NULL,
`IdRol` int NOT NULL,
`Activo` boolean NOT NULL ,
PRIMARY KEY (`IdUsuario`),
foreign key (`IdRol`) references roles(`IdRol`)
);

CREATE TABLE `TipoCuenta`
(
`IdTipoCuenta` int NOT NULL AUTO_INCREMENT,
`Descripcion` varchar(45) NOT NULL,
PRIMARY KEY (`IdTipoCuenta`)
) ;
CREATE TABLE `Cuentas`
(
`N_Cuenta` int AUTO_INCREMENT,
`F_Creacion` varchar(45) NOT NULL,
`IdUsuario` int NOT NULL ,
`CBU` varchar(45) NOT NULL ,
`IdTipoCuenta` int NOT NULL ,
`Saldo` float NOT NULL ,
`Activo` boolean NOT NULL ,
PRIMARY KEY (`N_Cuenta`),
foreign key (`IdUsuario`) references Usuarios(`IdUsuario`),
foreign key (`IdTipoCuenta`) references TipoCuenta(`IdTipoCuenta`)
) ;


CREATE TABLE `Prestamos`
(
`IdPrestamos` int NOT NULL AUTO_INCREMENT,
`IdCuenta` int NOT NULL ,
`MontoSolicitado` float NOT NULL ,
`MontoTotalPagar` float NOT NULL ,
`Meses_Pre` int NOT NULL ,
`Cuotas` int NOT NULL ,
`FechaInicio` date NOT NULL,/*AAAA-MM-DD*/
PRIMARY KEY (`IdPrestamos`),
foreign key (`IdCuenta`) references Cuentas(`N_Cuenta`)
) ;
CREATE TABLE `TipoMovimiento`
(
`IdTipoMovimiento` int NOT NULL ,
`Descripcion` varchar(45) NOT NULL,
PRIMARY KEY (`IdTipoMovimiento`)
);
CREATE TABLE `Moviminetos`
(
`IdMovimientos` int NOT NULL AUTO_INCREMENT,
`IdCuenta` int NOT NULL ,
`Descripcion` varchar(45) NOT NULL,
`IdTipoMovimiento` int NOT NULL ,
`Saldo` float NOT NULL ,
PRIMARY KEY (`IdMovimientos`),
foreign key (`IdTipoMovimiento`) references TipoMovimiento(`IdTipoMovimiento`),
foreign key (`IdCuenta`) references Cuentas(`N_Cuenta`)
) ;
CREATE TABLE `Trasferencias`
(
`IdTrasferencias` int NOT NULL AUTO_INCREMENT,
`IdCuentaOrigen` int NOT NULL ,
`IdCuentaDestino` int NOT NULL ,
`Monto` float NOT NULL ,
PRIMARY KEY (`IdTrasferencias`),
foreign key (`IdCuentaOrigen`) references Cuentas(`N_Cuenta`),
foreign key (`IdCuentaDestino`) references Cuentas(`N_Cuenta`)
) ;

ALTER TABLE usuarios ADD CONSTRAINT rol_id FOREIGN KEY (idRol) REFERENCES roles(idRol);

INSERT INTO roles VALUES (1,'Usuario');
INSERT INTO roles VALUES (2,'Administrador');

INSERT INTO tipocuenta VALUES (1,'Cuenta Corriente');
INSERT INTO tipocuenta VALUES (2,'Caja de ahorro');

DELIMITER $$
CREATE PROCEDURE SP_AgregarCuenta(f_creacion varchar(45),
									id_usuario int,
									cbu varchar(45),
									idTipoCuenta int,
									saldo float,
									activo bool)
BEGIN
	INSERT INTO cuentas (cuentas.F_Creacion,
    cuentas.IdUsuario,
    cuentas.CBU,
    cuentas.IdTipoCuenta,
    cuentas.Saldo,
    cuentas.Activo) 
    VALUES (f_creacion,
    id_usuario,
    cbu,
    idTipoCuenta,
    saldo,
    activo);
END$$

DELIMITER $$
CREATE PROCEDURE SP_AgregarUsuarios(
					dni INT, 
                    cuil INT, 
                    genero VARCHAR(15),
                    nacionalidad VARCHAR(45),
					fechaNac VARCHAR(45),
                    direccion VARCHAR(45), 
                    localidad VARCHAR(45),
					provincia VARCHAR(45),
                    telefono VARCHAR(45), 
                    nombreUsuario VARCHAR(45),
					nombre VARCHAR(45), 
                    apellido VARCHAR(45), 
                    email VARCHAR(75),
					pass VARCHAR(45),
                    idRol int)
BEGIN
	INSERT INTO usuarios (Dni,Cuil,Genero,Nacionalidad,F_Nacimiento,Direccion,
						Localidad,Provincia,Telefono,NombreUsuario,Nombre,
                        Apellido,Email,`Password`,IdRol,Activo) 
                        VALUES (dni,cuil,genero,nacionalidad,
                        STR_TO_DATE(fechaNac,'%d/%m/%Y'),direccion,
						localidad,provincia,telefono,nombreUsuario,nombre,
						apellido,email,pass,idRol,1);
END$$


------------------------------------------------------------

DELIMITER $$
CREATE PROCEDURE SP_EliminarUsuario(id INT)
BEGIN
	UPDATE usuarios SET Activo = 0 
    WHERE IdUsuario = id;
END$$



-------------------------------------------------------------------
DELIMITER $$
CREATE PROCEDURE SP_ModificarContraseña(dni INT,new_pass VARCHAR(45))
BEGIN
	UPDATE usuarios SET `Password` = new_pass
    WHERE Dni = dni;
END$$

-------------------------------------------------------------------

DELIMITER $$
CREATE PROCEDURE SP_ModificarUsuario(
					dni INT, 
                    cuil INT, 
                    genero VARCHAR(15),
                    nacionalidad VARCHAR(45),
					fechaNac VARCHAR(45),
                    direccion VARCHAR(45), 
                    localidad VARCHAR(45),
					provincia VARCHAR(45),
                    telefono VARCHAR(45), 
                    nombreUsuario VARCHAR(45),
					nombre VARCHAR(45), 
                    apellido VARCHAR(45), 
                    email VARCHAR(75),
					pass VARCHAR(45)
                    )
BEGIN
	UPDATE usuarios
		SET Dni = dni,
        Cuil = cuil,
        Genero = genero,
        Nacionalidad = nacionalidad,
        F_Nacimiento = fechaNac,
        Direccion = direccion,
        Localidad = localidad,
        Provincia = provincia,
        Telefono = telefono,
        NombreUsuario = nombreUsuario,
        Nombre = nombre,
        Apellido = apellido,
        Email = email,
        `Password` = pass;
END$$






CALL SP_AgregarUsuarios(33711136,23223,'M','argentino','19/04/1966','Alvear 801',
						'Tigre','BS AS','1133225544','ikeegan','ignacio','keegan',
                        'ignaciokeegan@gmail.com','abc123',1);



select * from cuentas;

select * from usuarios


