DROP DATABASE IF EXISTS bdGestionPedidos;
CREATE DATABASE bdGestionPedidos;
USE bdGestionPedidos;

-- Tabla para Direcciones con clave compuesta
CREATE TABLE ubigeo (
    id_ubigeo CHAR(6) PRIMARY KEY, -- ID único de la dirección
    distrito_ubi VARCHAR(20), -- Distrito
    provincia_ubi VARCHAR(20), -- Provincia
    calle_avend_ubi VARCHAR(50), -- Nombre de la calle o avenida (puede no ser obligatorio)
    num_calle_ubi INT, -- Número de la dirección (puede no ser obligatorio)
    referencia_ubi VARCHAR(150) -- Referencia adicional (puede no ser obligatorio)
);

-- Tabla para Contactos reutilizable
CREATE TABLE contacto (
    id_contac CHAR(6) PRIMARY KEY, -- ID único del contacto
    tipo_contac VARCHAR(50), -- Nombre del contacto
    telef_contac VARCHAR(15), -- Teléfono del contacto
    email_contac VARCHAR(100) -- Correo electrónico del contacto
);

-- Tabla para Proveedores
CREATE TABLE proveedor (
    id_prov CHAR(6) PRIMARY KEY, -- ID único del proveedor
    nom_prov VARCHAR(50) NOT NULL, -- Nombre del proveedor
    descd_prov TEXT, -- Descripción del proveedor
    id_ubigeo CHAR(6) NULL, -- ID único de la dirección
    FOREIGN KEY (id_ubigeo) REFERENCES ubigeo(id_ubigeo) -- Relación con dirección
);

-- Tabla de Empleados
CREATE TABLE empleado (
    id_emp CHAR(5) PRIMARY KEY,
    nom_pat_emp VARCHAR(25) NOT NULL,
    nom_mat_emp VARCHAR(25) NOT NULL,
    ape_pat_emp VARCHAR(25) NOT NULL,
    ape_mat_emp VARCHAR(25) NOT NULL,
    id_contac CHAR(6) NULL,
    cargo_emp VARCHAR(20) NOT NULL,
    id_ubigeo CHAR(6) NULL,
    fech_nac_emp DATE NOT NULL,
    password_emp VARBINARY(255) NOT NULL,
    FOREIGN KEY (id_contac) REFERENCES contacto(id_contac),
    FOREIGN KEY (id_ubigeo) REFERENCES ubigeo(id_ubigeo)
);

-- Tabla de relación para múltiples contactos por proveedor
CREATE TABLE proveedor_contacto (
    id_prov CHAR(6), -- ID único del proveedor
    id_contac CHAR(6), -- ID único del contacto
    PRIMARY KEY (id_prov, id_contac), -- Clave compuesta
    FOREIGN KEY (id_prov) REFERENCES proveedor(id_prov), -- Relación con proveedor
    FOREIGN KEY (id_contac) REFERENCES contacto(id_contac) -- Relación con contacto
);

-- Tabla de Categorías
CREATE TABLE categoria (
    id_ctg CHAR(5) PRIMARY KEY, -- ID único de categoría
    nom_ctg VARCHAR(25) NOT NULL -- Nombre de la categoría (Consumo, Limpieza, Perecibles, etc.)
);

-- Tabla de Productos
CREATE TABLE producto (
    id_produc CHAR(7) PRIMARY KEY, -- ID único del producto
    nom_produc VARCHAR(50) NOT NULL, -- Nombre del producto
    marca_produc VARCHAR(30) NOT NULL, -- Marca del producto
    precio_empaq_produc DECIMAL(10, 2) NOT NULL, -- Precio del empaque
    cant_x_empaq_produc INT NOT NULL, -- Cantidad de productos por empaque
    id_ctg CHAR(5) NOT NULL, -- ID de categoría
    tipo_empq_produc VARCHAR(20) NOT NULL, -- Tipo de medida (ej. Caja, Paquete, Bolsa)
    FOREIGN KEY (id_ctg) REFERENCES categoria(id_ctg) -- Relación con categoría
);

-- Tabla de Pedidos
CREATE TABLE pedido (
    id_pedi CHAR(7) PRIMARY KEY,
    fech_pedi DATE NOT NULL,
    hora_pedi TIME NOT NULL,
    id_prov CHAR(6) NOT NULL,
    id_emp CHAR(5) NOT NULL,
    estado_pedi VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_prov) REFERENCES proveedor(id_prov),
    FOREIGN KEY (id_emp) REFERENCES empleado(id_emp)
);

-- Tabla de Detalles del Pedido con PedidoID como parte de la clave primaria
CREATE TABLE detalle_pedido (
    id_pedi CHAR(7) NOT NULL, -- Parte de la clave primaria y clave foránea
    id_produc CHAR(7) NOT NULL,
    cant_produc_pedi INT NOT NULL,
    precio_tot_pedi DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_pedi) REFERENCES pedido(id_pedi),
    FOREIGN KEY (id_produc) REFERENCES producto(id_produc),
    PRIMARY KEY (id_pedi, id_produc) -- Clave primaria compuesta
);

-- Tabla de Guías de Entrega
CREATE TABLE guia_entrega (
    id_guia CHAR(7) PRIMARY KEY, -- ID único de la guía de entrega
    id_pedi CHAR(7) NOT NULL, -- ID del pedido relacionado
    fech_entrg DATE NOT NULL, -- Fecha de entrega
    FOREIGN KEY (id_pedi) REFERENCES pedido(id_pedi) -- Relación con el pedido
);

-- Rellenado de tablas
-- Insertar datos de contactos
INSERT INTO contacto (id_contac, tipo_contac, telef_contac, email_contac)
VALUES
    ('CON001', 'Gerente', '+51 999 555 111', 'gerente@masslocal.com'),
    ('CON002', 'Ventas', '+51 999 555 222', 'ventas@masslocal.com'),
    ('CON003', 'Cajero', '+51 999 555 333', 'cajero@masslocal.com'),
    ('CON004', 'Reponedor', '+51 999 555 444', 'reponedor@masslocal.com'),
    ('CON005', 'Ventas', '+51 999 555 555', 'ventas2@masslocal.com'),
    ('CON006', 'Ventas', '+51 987 654 321', 'ventas@cocacola.com'),
    ('CON007', 'Ventas', '+51 987 123 456', 'ventas@backus.com'),
    ('CON008', 'Atención al Cliente', '+51 981 234 567', 'contacto@sanmateo.com'),
    ('CON009', 'Ventas', '+51 981 345 678', 'ventas@inkatea.com'),
    ('CON010', 'Atención al Cliente', '+51 976 543 210', 'atencion@donjorge.com'),
    ('CON011', 'Ventas', '+51 975 432 109', 'ventas@redbull.com'),
    ('CON012', 'Ventas', '+51 987 654 321', 'ventas@bimbo.com'),
    ('CON013', 'Ventas', '+51 987 123 456', 'ventas@tanta.com'),
    ('CON014', 'Atención al Cliente', '+51 981 234 567', 'atencion@pasquale.com'),
    ('CON015', 'Ventas', '+51 981 345 678', 'ventas@mistura.com'),
    ('CON016', 'Ventas', '+51 976 543 210', 'ventas@lamora.com'),
    ('CON017', 'Atención al Cliente', '+51 975 432 109', 'atencion@pandelachola.com'),
    ('CON018', 'Ventas', '+51 987 654 321', 'ventas@inkachips.com'),
    ('CON019', 'Ventas', '+51 987 123 456', 'ventas@lays.com'),
    ('CON020', 'Atención al Cliente', '+51 981 234 567', 'atencion@laiberica.com'),
    ('CON021', 'Ventas', '+51 981 345 678', 'ventas@field.com'),
    ('CON022', 'Ventas', '+51 976 543 210', 'ventas@elidolo.com'),
    ('CON023', 'Atención al Cliente', '+51 975 432 109', 'atencion@gloria.com'),
    ('CON024', 'Ventas', '+51 981 234 567', 'ventas@yoplait.com'),
    ('CON025', 'Ventas', '+51 987 654 321', 'ventas@almendrina.com'),
    ('CON026', 'Atención al Cliente', '+51 987 123 456', 'atencion@bonle.com'),
    ('CON027', 'Ventas', '+51 981 234 567', 'ventas@ace.com'),
    ('CON028', 'Ventas', '+51 981 345 678', 'ventas@sapolio.com'),
    ('CON029', 'Atención al Cliente', '+51 976 543 210', 'atencion@poett.com'),
    ('CON030', 'Ventas', '+51 975 432 109', 'ventas@nova.com'),
    ('CON031', 'Ventas', '+51 987 654 321', 'ventas@noria.com'),
    ('CON032', 'Atención al Cliente', '+51 987 123 456', 'atencion@pinklady.com'),
    ('CON033', 'Ventas', '+51 981 234 567', 'ventas@delmonte.com'),
    ('CON034', 'Ventas', '+51 981 345 678', 'ventas@sanfernando.com'),
    ('CON035', 'Atención al Cliente', '+51 976 543 210', 'atencion@sancamilo.com'),
    ('CON036', 'Ventas', '+51 975 432 109', 'ventas@santarosa.com'),
    ('CON037', 'Ventas', '+51 987 654 321', 'ventas@lachacra.com'),
    ('CON038', 'Atención al Cliente', '+51 987 123 456', 'atencion@elcampesino.com'),
    ('CON039', 'Ventas', '+51 981 234 567', 'ventas@todini.com'),
    ('CON040', 'Ventas', '+51 981 345 678', 'ventas@digiorno.com'),
    ('CON041', 'Atención al Cliente', '+51 976 543 210', 'atencion@mccain.com'),
    ('CON042', 'Ventas', '+51 975 432 109', 'ventas@tyson.com'),
    ('CON043', 'Ventas', '+51 987 654 321', 'ventas@gortons.com'),
    ('CON044', 'Atención al Cliente', '+51 987 123 456', 'atencion@birdseye.com'),
    ('CON045', 'Ventas', '+51 981 234 567', 'ventas@pantene.com'),
    ('CON046', 'Ventas', '+51 981 345 678', 'ventas@sedal.com'),
    ('CON047', 'Atención al Cliente', '+51 976 543 210', 'atencion@dove.com'),
    ('CON048', 'Ventas', '+51 975 432 109', 'ventas@rexona.com'),
    ('CON049', 'Ventas', '+51 987 654 321', 'ventas@scott.com');

-- Insertar datos de direcciones
INSERT INTO ubigeo (id_ubigeo, distrito_ubi, provincia_ubi, calle_avend_ubi, num_calle_ubi, referencia_ubi)
VALUES
    ('DIR001', 'Miraflores', 'Lima', 'Av. Larco', 123, 'Frente al parque'),
    ('DIR002', 'San Isidro', 'Lima', 'Av. Arequipa', 456, 'Esquina con la Av. Salaverry'),
    ('DIR003', 'Surco', 'Lima', 'Av. Caminos del Inca', 789, 'Cerca al Mall del Sur'),
    ('DIR004', 'Barranco', 'Lima', 'Jr. Grau', 321, 'Entre las calles Los Pescadores y Malecón'),
    ('DIR005', 'Lince', 'Lima', 'Av. Arequipa', 1234, 'Frente al Hospital'),
    ('DIR006', 'San Borja', 'Lima', 'Av. Aviación', 567, 'Al costado del Polideportivo'),
    ('DIR007', 'Magdalena', 'Lima', 'Av. Brasil', 789, 'Frente a la Plaza de Magdalena'),
    ('DIR008', 'Pueblo Libre', 'Lima', 'Av. Sucre', 1011, 'Junto a la municipalidad'),
    ('DIR009', 'Ate', 'Lima', 'Av. Los Incas', 1213, 'Cerca al centro comercial'),
    ('DIR010', 'Miraflores', 'Lima', 'Av. Benavides', 123, 'Edificio Los Pinos'),
    ('DIR011', 'San Isidro', 'Lima', 'Av. Camino Real', 456, 'Edificio Las Palmas'),
    ('DIR012', 'La Molina', 'Lima', 'Av. Los Fresnos', 789, 'Edificio Los Pájaros'),
    ('DIR013', 'San Borja', 'Lima', 'Av. Aviación', 246, 'Edificio Los Cerezos'),
    ('DIR014', 'Surco', 'Lima', 'Av. Primavera', 789, 'Edificio Las Flores'),
    ('DIR015', 'San Miguel', 'Lima', 'Av. La Marina', 321, 'Edificio Las Palmas'),
    ('DIR016', 'Los Olivos', 'Lima', 'Av. Universitaria', 456, 'Edificio Los Laureles'),
    ('DIR017', 'Pueblo Libre', 'Lima', 'Av. Bolívar', 753, 'Edificio Las Acacias'),
    ('DIR018', 'Magdalena', 'Lima', 'Av. Sucre', 852, 'Edificio Las Margaritas'),
    ('DIR019', 'Chorrillos', 'Lima', 'Av. Huaylas', 951, 'Edificio Los Girasoles'),
    ('DIR020', 'Barranco', 'Lima', 'Av. Bolognesi', 369, 'Edificio Los Pájaros'),
    ('DIR021', 'Villa el Salvador', 'Lima', 'Av. Pachacútec', 753, 'Edificio Las Palmeras'),
    ('DIR022', 'San Juan de Lurigancho', 'Lima', 'Av. Próceres', 951, 'Edificio Las Rosas'),
    ('DIR023', 'La Victoria', 'Lima', 'Av. Iquitos', 852, 'Edificio Los Almendros'),
    ('DIR024', 'San Juan de Miraflores', 'Lima', 'Av. Los Héroes', 369, 'Edificio Las Acacias'),
    ('DIR025', 'Cercado de Lima', 'Lima', 'Jirón de la Unión', 753, 'Edificio Los Laureles'),
    ('DIR026', 'Surquillo', 'Lima', 'Av. Angamos', 456, 'Edificio Las Palmeras'),
    ('DIR027', 'Ate', 'Lima', 'Av. Metropolitana', 852, 'Edificio Las Margaritas'),
    ('DIR028', 'Callao', 'Callao', 'Av. Sáenz Peña', 951, 'Edificio Los Cerezos'),
    ('DIR029', 'Ventanilla', 'Callao', 'Av. Gambetta', 369, 'Edificio Las Flores'),
    ('DIR030', 'Ancón', 'Lima', 'Av. Ancón', 753, 'Edificio Las Palmas'),
    ('DIR031', 'Punta Hermosa', 'Lima', 'Av. Playa Blanca', 456, 'Edificio Los Laureles'),
    ('DIR032', 'Punta Negra', 'Lima', 'Av. Las Arenas', 852, 'Edificio Las Rosas'),
    ('DIR033', 'Santa María', 'Lima', 'Av. Santa María', 951, 'Edificio Las Palmeras'),
    ('DIR034', 'Asia', 'Lima', 'Av. Del Mar', 369, 'Edificio Las Acacias'),
    ('DIR035', 'Pucusana', 'Lima', 'Av. Pucusana', 753, 'Edificio Las Margaritas'),
    ('DIR036', 'Canta', 'Lima', 'Av. Canta', 852, 'Edificio Los Girasoles'),
    ('DIR037', 'Huaral', 'Lima', 'Av. Huaral', 951, 'Edificio Las Rosas'),
    ('DIR038', 'Chincha', 'Ica', 'Av. Chincha', 369, 'Edificio Las Palmeras'),
    ('DIR039', 'Pisco', 'Ica', 'Av. Pisco', 753, 'Edificio Los Almendros'),
    ('DIR040', 'Ica', 'Ica', 'Av. Ica', 456, 'Edificio Los Girasoles'),
    ('DIR041', 'Paracas', 'Ica', 'Av. Paracas', 852, 'Edificio Las Flores'),
    ('DIR042', 'Nazca', 'Ica', 'Av. Nazca', 951, 'Edificio Las Rosas'),
    ('DIR043', 'Cusco', 'Cusco', 'Av. Cusco', 369, 'Edificio Las Palmeras'),
    ('DIR044', 'Arequipa', 'Arequipa', 'Av. Arequipa', 753, 'Edificio Las Acacias'),
    ('DIR045', 'Tacna', 'Tacna', 'Av. Tacna', 852, 'Edificio Los Almendros'),
    ('DIR046', 'Puno', 'Puno', 'Av. Puno', 951, 'Edificio Los Girasoles'),
    ('DIR047', 'Ayacucho', 'Ayacucho', 'Av. Ayacucho', 369, 'Edificio Las Rosas'),
    ('DIR048', 'Trujillo', 'La Libertad', 'Av. Trujillo', 753, 'Edificio Las Flores'),
    ('DIR049', 'Chiclayo', 'Lambayeque', 'Av. Chiclayo', 852, 'Edificio Las Palmeras'),
    ('DIR050', 'Piura', 'Piura', 'Av. Piura', 951, 'Edificio Las Margaritas');


-- Insertar datos de empleados
INSERT INTO empleado (id_emp, nom_pat_emp, nom_mat_emp, ape_pat_emp, ape_mat_emp, id_contac, cargo_emp, id_ubigeo, fech_nac_emp, password_emp)
VALUES
    ('EMP01', 'Juan', 'García', 'Pérez', 'López', 'CON001', 'Gerente', 'DIR001', '1980-02-15', AES_ENCRYPT('ADMIN1', 'aB7xY9zL3pQ')),
    ('EMP02', 'María', 'Martínez', 'Fernández', 'Rodríguez', 'CON002', 'Vendedor', 'DIR002', '1985-07-21', AES_ENCRYPT('vendedor44', 'aB7xY9zL3pQ')),
    ('EMP03', 'Carlos', 'Gómez', 'Sánchez', 'Díaz', 'CON003', 'Cajero', 'DIR003', '1990-11-10', AES_ENCRYPT('cajero1123', 'aB7xY9zL3pQ')),
    ('EMP04', 'Laura', 'Torres', 'Jiménez', 'Hernández', 'CON004', 'Reponedor', 'DIR004', '1993-03-30', AES_ENCRYPT('repo4467', 'aB7xY9zL3pQ')),
    ('EMP05', 'Pedro', 'Ruiz', 'Alvarez', 'Santos', 'CON005', 'Vendedor', 'DIR005', '1988-05-05', AES_ENCRYPT('vendedor11', 'aB7xY9zL3pQ')),
    ('EMP06', 'Flavio', 'Sebastian', 'Villanueva', 'Medina', NULL, 'Reponedor', NULL, '2004-01-28', AES_ENCRYPT('reponedor4324', 'aB7xY9zL3pQ'));

-- Insertar datos de categorías de productos
INSERT INTO categoria (id_ctg, nom_ctg)
VALUES
    ('CTG01', 'Bebidas'),
    ('CTG02', 'Panadería'),
    ('CTG03', 'Snacks'),
    ('CTG04', 'Lácteos'),
    ('CTG05', 'Limpieza'),
    ('CTG06', 'Frutas y Verduras'),
    ('CTG07', 'Carnes y Aves'),
    ('CTG08', 'Congelados'),
    ('CTG09', 'Cuidado Personal');

-- Insertar productos en la categoría 'Bebidas' (CTG01)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD001', 'Inca Kola', 'The Coca-Cola Company', 47.88, 12, 'CTG01', 'Palet'),
    ('PROD051', 'Coca Kola', 'The Coca-Cola Company', 50.90, 12, 'CTG01', 'Palet'),
    ('PROD052', 'Fanta de Naranja', 'The Coca-Cola Company', 47.88, 12, 'CTG01', 'Palet'),
    ('PROD053', 'Fanta Kola Inglesa', 'The Coca-Cola Company', 31.55, 12, 'CTG01', 'Palet'),
    ('PROD002', 'Cerveza Cusqueña', 'Backus', 88.88, 12, 'CTG01', 'Caja'),
    ('PROD054', 'Cerveza Cristal', 'Backus', 77.88, 12, 'CTG01', 'Caja'),
    ('PROD055', 'Cerveza Pilsen', 'Backus', 89.88, 12, 'CTG01', 'Caja'),
    ('PROD056', 'Cerveza Golden', 'Backus', 51.88, 12, 'CTG01', 'Caja'),
    ('PROD057', 'Cerveza Cusqueña Negra', 'Backus', 81.88, 12, 'CTG01', 'Caja'),
    ('PROD003', 'Agua San Mateo', 'San Mateo', 35.88, 12, 'CTG01', 'Palet'),
    ('PROD004', 'Té de Manzanilla', 'Inka Tea', 27.00, 6, 'CTG01', 'Pack'),
    ('PROD005', 'Chicha Morada', 'Don Jorge', 89.25, 24, 'CTG01', 'Pack'),
    ('PROD006', 'Energizante Red Bull', 'Red Bull', 167.76, 24, 'CTG01', 'Pack');


-- Insertar productos en la categoría 'Panadería' (CTG02)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD007', 'Pan Integral', 'Bimbo', 33.00, 10, 'CTG02', 'Cesta'),
    ('PROD058', 'Pan Blanco', 'Bimbo', 49.00, 10, 'CTG02', 'Cesta'),
    ('PROD059', 'Tortilla Integral', 'Bimbo', 26.00, 10, 'CTG02', 'Cesta'),
    ('PROD060', 'Tortilla de Trigo', 'Bimbo', 22.00, 10, 'CTG02', 'Cesta'),
    ('PROD008', 'Pan Francés', 'Tanta', 39.00, 10, 'CTG02', 'Caja'),
    ('PROD009', 'Rosquitas de Viento', 'Pasquale', 46.80, 12, 'CTG02', 'Caja'),
    ('PROD010', 'Croissant de Chocolate', 'Mistura', 35.40, 6, 'CTG02', 'Pack'),
    ('PROD011', 'Pan de Centeno', 'La Mora', 49.00, 10, 'CTG02', 'Caja'),
    ('PROD012', 'Pan Integral con Semillas', 'Pan de la Chola', 39.00, 6, 'CTG02', 'Pack');

-- Insertar productos en la categoría 'Snacks' (CTG03)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD013', 'Papas Fritas Sal de Mara', 'Inka Chips', 35.00, 10, 'CTG03', 'Paquete'),
    ('PROD062', 'Papas Fritas BBQ', 'Inka Chips', 35.00, 10, 'CTG03', 'Paquete'),
    ('PROD063', 'Papas Fritas Jalapeño', 'Inka Chips', 35.00, 10, 'CTG03', 'Paquete'),
    ('PROD014', 'Piqueo Mixto', 'Lays', 23.00, 12, 'CTG03', 'Paquete'),
    ('PROD064', 'Papas Fritas', 'Lays', 21.00, 10, 'CTG03', 'Paquete'),
    ('PROD065', 'Dorits', 'Lays', 24.00, 10, 'CTG03', 'Paquete'),
    ('PROD015', 'Chocotejas', 'La Ibérica', 58.80, 24, 'CTG03', 'Caja'),
    ('PROD016', 'Chocolate Doña Pepa', 'Field', 119.40, 30, 'CTG03', 'Caja'),
    ('PROD017', 'Cua Cua', 'Field', 58.80, 12, 'CTG03', 'Caja'),
    ('PROD066', 'Galleta Chokosoda', 'Field', 21.80, 12, 'CTG03', 'Caja'),
    ('PROD067', 'Galleta Vainilla', 'Field', 15.80, 12, 'CTG03', 'Caja'),
    ('PROD068', 'Galleta Charada', 'Field', 45.80, 12, 'CTG03', 'Caja'),
    ('PROD018', 'Chifles', 'El Ídolo', 70.00, 20, 'CTG03', 'Caja');
    
-- Insertar productos en la categoría 'Lácteos' (CTG04)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD019', 'Leche Evaporada', 'Gloria', 42.00, 12, 'CTG04', 'Caja'),
    ('PROD020', 'Yogur Natural', 'Gloria', 17.94, 6, 'CTG04', 'Pack'),
    ('PROD021', 'Leche de Almendras', 'Almendrina', 31.92, 4, 'CTG04', 'Pack'),
    ('PROD022', 'Yogur Griego', 'Laive', 19.50, 6, 'CTG04', 'Pack'),
    ('PROD023', 'Queso Fresco', 'Bonle', 36.00, 8, 'CTG04', 'Caja'),
    ('PROD024', 'Mantequilla', 'Laive', 22.50, 10, 'CTG04', 'Caja');
    
-- Insertar productos en la categoría 'Limpieza' (CTG05)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD025', 'Detergente', 'Ace', 65.00, 10, 'CTG05', 'Caja'),
    ('PROD026', 'Lavavajillas', 'Sapolio', 57.50, 10, 'CTG05', 'Caja'),
    ('PROD027', 'Cloro', 'Poett', 35.00, 10, 'CTG05', 'Caja'),
    ('PROD028', 'Limpiavidrios', 'Sapolio', 49.90, 10, 'CTG05', 'Caja'),
    ('PROD029', 'Toallas de Papel', 'Nova', 55.00, 20, 'CTG05', 'Caja'),
    ('PROD030', 'Detergente en Barra', 'Ace', 15.00, 10, 'CTG05', 'Caja');

-- Insertar productos en la categoría 'Frutas y Verduras' (CTG06)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD031', 'Manzanas', 'Pink Lady', 119.40, 30, 'CTG06', 'Caja'),
    ('PROD032', 'Bananas', 'Del Monte', 23.94, 6, 'CTG06', 'Pack'),
    ('PROD033', 'Zanahorias', 'Del Monte', 23.76, 12, 'CTG06', 'Caja'),
    ('PROD034', 'Tomates', 'San Camilo', 119.40, 30, 'CTG06', 'Caja'),
    ('PROD035', 'Lechuga', 'Del Monte', 22.50, 10, 'CTG06', 'Caja');

-- Insertar productos en la categoría 'Carnes y Aves' (CTG07)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD036', 'Pollo Entero', 'San Fernando', 94.90, 10, 'CTG07', 'Caja'),
    ('PROD037', 'Res Filete', 'San Fernando', 77.94, 6, 'CTG07', 'Pack'),
    ('PROD038', 'Cerdo Asado', 'El Campesino', 87.50, 10, 'CTG07', 'Caja'),
    ('PROD039', 'Jamón de Pavo', 'Todini', 29.94, 6, 'CTG07', 'Pack'),
    ('PROD040', 'Salchichas', 'San Fernando', 35.00, 10, 'CTG07', 'Caja');

-- Insertar productos en la categoría 'Congelados' (CTG08)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD041', 'Pizza Congelada', 'DiGiorno', 55.92, 12, 'CTG08', 'Caja'),
    ('PROD042', 'Papas Fritas Congeladas', 'DiGiorno', 45.00, 10, 'CTG08', 'Caja'),
    ('PROD043', 'Nuggets de Pollo', 'San Fernando', 35.94, 6, 'CTG08', 'Pack'),
    ('PROD044', 'Filetes de Pescado', 'Gorton’s', 37.50, 10, 'CTG08', 'Caja'),
    ('PROD045', 'Vegetales Mixtos', 'Birds Eye', 79.80, 20, 'CTG08', 'Caja');

-- Insertar productos en la categoría 'Cuidado Personal' (CTG09)
INSERT INTO producto (id_produc, nom_produc, marca_produc, precio_empaq_produc, cant_x_empaq_produc, id_ctg, tipo_empq_produc)
VALUES
    ('PROD046', 'Champú', 'Pantene', 49.50, 6, 'CTG09', 'Pack'),
    ('PROD047', 'Acondicionador', 'Sedal', 47.94, 6, 'CTG09', 'Pack'),
    ('PROD048', 'Jabón Corporal', 'Dove', 54.00, 12, 'CTG09', 'Caja'),
    ('PROD049', 'Desodorante', 'Rexona', 47.88, 12, 'CTG09', 'Caja'),
    ('PROD050', 'Papel Higiénico', 'Scott', 43.00, 30, 'CTG09', 'Caja');

-- Insertar datos de proveedores basados en las empresas mencionadas
INSERT INTO proveedor (id_prov, nom_prov, descd_prov, id_ubigeo)
VALUES
    ('PROV01', 'The Coca-Cola Company', 'Proveedor de bebidas', 'DIR010'),
    ('PROV02', 'Backus', 'Proveedor de cervezas', 'DIR011'),
    ('PROV03', 'San Mateo', 'Proveedor de agua', 'DIR012'),
    ('PROV04', 'Inka Tea', 'Proveedor de infusiones', 'DIR013'),
    ('PROV05', 'Don Jorge', 'Proveedor de bebidas', 'DIR014'),
    ('PROV06', 'Red Bull', 'Proveedor de bebidas energizantes', 'DIR015'),
    ('PROV07', 'Bimbo', 'Proveedor de panadería', 'DIR016'),
    ('PROV08', 'Tanta', 'Proveedor de panadería', 'DIR017'),
    ('PROV09', 'Pasquale', 'Proveedor de panadería', 'DIR018'),
    ('PROV10', 'Mistura', 'Proveedor de panadería', 'DIR019'),
    ('PROV11', 'La Mora', 'Proveedor de panadería', 'DIR020'),
    ('PROV12', 'Pan de la Chola', 'Proveedor de panadería', 'DIR021'),
    ('PROV13', 'Inka Chips', 'Proveedor de snacks', 'DIR022'),
    ('PROV14', 'Lays', 'Proveedor de snacks', 'DIR023'),
    ('PROV15', 'La Ibérica', 'Proveedor de chocolates', 'DIR024'),
    ('PROV16', 'Field', 'Proveedor de snacks', 'DIR025'),
    ('PROV17', 'El Ídolo', 'Proveedor de snacks', 'DIR026'),
    ('PROV18', 'Gloria', 'Proveedor de lácteos', 'DIR027'),
    ('PROV19', 'Yoplait', 'Proveedor de productos lácteos', 'DIR028'),
    ('PROV20', 'Almendrina', 'Proveedor de leche de almendras', 'DIR029'),
    ('PROV21', 'Bonle', 'Proveedor de lácteos', 'DIR030'),
    ('PROV22', 'Ace', 'Proveedor de productos de limpieza', 'DIR031'),
    ('PROV23', 'Sapolio', 'Proveedor de productos de limpieza', 'DIR032'),
    ('PROV24', 'Poett', 'Proveedor de productos de limpieza', 'DIR033'),
    ('PROV25', 'Nova', 'Proveedor de productos de limpieza', 'DIR034'),
    ('PROV26', 'Noria', 'Proveedor de productos de limpieza', 'DIR035'),
    ('PROV27', 'Pink Lady', 'Proveedor de frutas y verduras', 'DIR036'),
    ('PROV28', 'Del Monte', 'Proveedor de frutas y verduras', 'DIR037'),
    ('PROV29', 'San Fernando', 'Proveedor de frutas y verduras', 'DIR038'),
    ('PROV30', 'San Camilo', 'Proveedor de frutas y verduras', 'DIR039'),
    ('PROV31', 'Santa Rosa', 'Proveedor de frutas y verduras', 'DIR040'),
    ('PROV32', 'La Chacra', 'Proveedor de carnes y aves', 'DIR041'),
    ('PROV33', 'El Campesino', 'Proveedor de carnes y aves', 'DIR042'),
    ('PROV34', 'Todini', 'Proveedor de embutidos', 'DIR043'),
    ('PROV35', 'DiGiorno', 'Proveedor de alimentos congelados', 'DIR044'),
    ('PROV36', 'McCain', 'Proveedor de alimentos congelados', 'DIR045'),
    ('PROV37', 'Tyson', 'Proveedor de alimentos congelados', 'DIR046'),
    ('PROV38', 'Gorton’s', 'Proveedor de alimentos congelados', 'DIR047'),
    ('PROV39', 'Birds Eye', 'Proveedor de alimentos congelados', 'DIR048'),
    ('PROV40', 'Pantene', 'Proveedor de productos de cuidado personal', 'DIR049'),
    ('PROV41', 'Sedal', 'Proveedor de productos de cuidado personal', 'DIR050'),
    ('PROV42', 'Dove', 'Proveedor de productos de cuidado personal', 'DIR026'),
    ('PROV43', 'Rexona', 'Proveedor de productos de cuidado personal', 'DIR026'),
    ('PROV44', 'Scott', 'Proveedor de productos de cuidado personal', 'DIR026');

-- Insertar datos de contacto para los proveedores en la tabla de relación proveedor_contacto
INSERT INTO proveedor_contacto (id_prov, id_contac)
VALUES
    ('PROV01', 'CON006'),
    ('PROV02', 'CON007'),
    ('PROV03', 'CON008'),
    ('PROV04', 'CON009'),
    ('PROV05', 'CON010'),
    ('PROV06', 'CON011'),
    ('PROV07', 'CON012'),
    ('PROV08', 'CON013'),
    ('PROV09', 'CON014'),
    ('PROV10', 'CON015'),
    ('PROV11', 'CON016'),
    ('PROV12', 'CON017'),
    ('PROV13', 'CON018'),
    ('PROV14', 'CON019'),
    ('PROV15', 'CON020'),
    ('PROV16', 'CON021'),
    ('PROV17', 'CON022'),
    ('PROV18', 'CON023'),
    ('PROV19', 'CON024'),
    ('PROV20', 'CON025'),
    ('PROV21', 'CON026'),
    ('PROV22', 'CON027'),
    ('PROV23', 'CON028'),
    ('PROV24', 'CON029'),
    ('PROV25', 'CON030'),
    ('PROV26', 'CON031'),
    ('PROV27', 'CON032'),
    ('PROV28', 'CON033'),
    ('PROV29', 'CON034'),
    ('PROV30', 'CON035'),
    ('PROV31', 'CON036'),
    ('PROV32', 'CON037'),
    ('PROV33', 'CON038'),
    ('PROV34', 'CON039'),
    ('PROV35', 'CON040'),
    ('PROV36', 'CON041'),
    ('PROV37', 'CON042'),
    ('PROV38', 'CON043'),
    ('PROV39', 'CON044'),
    ('PROV40', 'CON045'),
    ('PROV41', 'CON046'),
    ('PROV42', 'CON047'),
    ('PROV43', 'CON048'),
    ('PROV44', 'CON049');

-- Procedure para login
-- Procedure para login
DELIMITER //

CREATE PROCEDURE sp_login_emp(
    IN p_codigo_empleado CHAR(5),
    IN p_contrasena VARCHAR(15)
)
BEGIN
    DECLARE decrypted_password VARCHAR(255);

    -- Desencriptar la contraseña almacenada en la base de datos
    SELECT TRIM(AES_DECRYPT(password_emp, 'aB7xY9zL3pQ')) INTO decrypted_password
    FROM empleado
    WHERE id_emp = p_codigo_empleado;

    -- Verificar si las contraseñas coinciden
    IF TRIM(decrypted_password) = TRIM(p_contrasena) THEN
        -- Autenticación exitosa, devolver datos del empleado
        SELECT *
        FROM empleado
        WHERE id_emp = p_codigo_empleado;
    END IF;
END //

DELIMITER ;

-- PROCEDURE PARA AGREGAR UN NUEVO EMPLEADO
DELIMITER @@
CREATE PROCEDURE spAdicionEmpleado(
    IN nom_pat_emp VARCHAR(25),
    IN nom_mat_emp VARCHAR(25),
    IN ape_pat_emp VARCHAR(25),
    IN ape_mat_emp VARCHAR(25),
    IN cargo_emp VARCHAR(20),
    IN fech_nac_emp DATE,
    IN password_emp VARBINARY(255) 
)
BEGIN
    DECLARE nuevoID CHAR(5);

    -- Generar nuevo ID para empleado
    SET nuevoID = CONCAT('EMP', LPAD((SELECT IFNULL(MAX(SUBSTRING(id_emp, 4)) + 1, 1) FROM empleado), 2, '0'));

    -- Insertar el nuevo empleado
    INSERT INTO empleado (
        id_emp,
        nom_pat_emp,
        nom_mat_emp,
        ape_pat_emp,
        ape_mat_emp,
        cargo_emp,
        fech_nac_emp,
        password_emp
    ) VALUES (
        nuevoID,
        nom_pat_emp,
        nom_mat_emp,
        ape_pat_emp,
        ape_mat_emp,
        cargo_emp,
        fech_nac_emp,
        CAST(AES_ENCRYPT(password_emp, 'aB7xY9zL3pQ') AS CHAR)
    );
END@@

DELIMITER ;



-- PROCEDURE PARA AGREGAR CONTACTO AL EMPLEADO
DELIMITER @@
CREATE PROCEDURE spAdiContactoEmp(
    IN tipo_contac VARCHAR(50),
    IN telef_contac VARCHAR(15),
    IN email_contac VARCHAR(100)
)
BEGIN
    DECLARE nuevoID_contac CHAR(6);
    DECLARE ultimoID_emp CHAR(5);

    -- Obtener el último ID de empleado
    SELECT id_emp INTO ultimoID_emp
    FROM empleado
    ORDER BY id_emp DESC
    LIMIT 1;

    -- Generar nuevo ID para contacto
    SET nuevoID_contac = CONCAT('CON', LPAD((SELECT IFNULL(MAX(SUBSTRING(id_contac, 4)) + 1, 1) FROM contacto), 3, '0'));

    -- Insertar el nuevo contacto
    INSERT INTO contacto (id_contac, tipo_contac, telef_contac, email_contac)
    VALUES (nuevoID_contac, tipo_contac, telef_contac, email_contac);

    -- Actualizar el ID de contacto en el último empleado
    UPDATE empleado
    SET id_contac = nuevoID_contac
    WHERE id_emp = ultimoID_emp;
END@@
DELIMITER ;


-- PROCEDURE PARA AGREGAR UBIGEO AL EMPLEADO
DELIMITER @@
CREATE PROCEDURE spAdiUbigeoEmp(
    IN distrito_ubi VARCHAR(20),	
    IN provincia_ubi VARCHAR(20),
    IN calle_avend_ubi VARCHAR(50),
    IN num_calle_ubi INT,
    IN referencia_ubi VARCHAR(150)
)
BEGIN
    DECLARE nuevoID_ubigeo CHAR(6);
    DECLARE ultimoID_emp CHAR(5);

    -- Obtener el último ID de empleado
    SELECT id_emp INTO ultimoID_emp
    FROM empleado
    ORDER BY id_emp DESC
    LIMIT 1;

    -- Generar nuevo ID para ubigeo
    SET nuevoID_ubigeo = CONCAT('DIR', LPAD((SELECT IFNULL(MAX(SUBSTRING(id_ubigeo, 4)) + 1, 1) FROM ubigeo), 3, '0'));

    -- Insertar el nuevo ubigeo
    INSERT INTO ubigeo (id_ubigeo, distrito_ubi, provincia_ubi, calle_avend_ubi, num_calle_ubi, referencia_ubi)
    VALUES (nuevoID_ubigeo, distrito_ubi, provincia_ubi, calle_avend_ubi, num_calle_ubi, referencia_ubi);

    -- Actualizar el ID de ubigeo en el último empleado
    UPDATE empleado
    SET id_ubigeo = nuevoID_ubigeo
    WHERE id_emp = ultimoID_emp;
END@@
DELIMITER ;
