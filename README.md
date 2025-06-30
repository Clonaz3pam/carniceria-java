Carniceria-Java

Aplicación de escritorio que simula la compra en una carnicería. Utilice arquitectura de capas (igu, lógica y persistencia), JPA (EclipseLink) y base de datos MySQL.

Cuenta con un logueo previo (creación de usuarios mediante la base de datos), donde se puede ser cliente o dueño.

Cuenta cliente: 
	nombre: cliente3
	contraseña: cliente
#Cliente

. Podrás ver los productos disponibles que posee la carnicería (Nombre, precio KG, stock)
- Al seleccionar un producto de la tabla, se mostrara una breve descripción del producto.
- Podrás indicar la cantidad en kilogramos a pedir de los productos. 
- Es posible dejarle un mensaje al carnicero de cómo querrás el corte (tamaño, porcentaje de carne y grasa, etc.).
- Cuando te decidas agregar un producto, este se agrega de forma automática a tu "Carrito".
- En mi "Carrito" podrás eliminar productos, cancelar la compra y finalizar la compra.


Cuenta dueño:
	nombre: duenio
	contraseña: 12345

"Dueño

- Creación de nuevos productos.
- Edición de productos ya existentes.
- Eliminación de productos.
- Actualización de la tabla.
- Cerrar la tabla.

Instrucciones:

1- Clonar el repositorio
 	git clone https://github.com/Clonaz3pam/carniceria-java.git
2- Abrir proyecto en NetBeans
3- Configurar base de datos MySQL
	- Abrir WAMP o tu servidor MySQL
	- Crear una nueva base de datos llamada carniceria1
	- Importar el archivo carniceria1.sql 
	- Desde phpMyAdmin seleccionar la base de datos - pestaña importar - elegir carniceria1.sql - clic continuar.
4- Verificar conexión a la base de datos en NetBeans
	- Revisar persistence.xml para confirmar que los datos coincidan: 
	<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/carniceria1"/>
	<property name="javax.persistence.jdbc.user" value="root"/>
	<property name="javax.persistence.jdbc.password" value=""/>
  	- Cambiar root y contraseña si usas otros datos.
