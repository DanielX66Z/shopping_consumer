# shopping_consumer
Orquestador a microservicio base de datos

Proyecto de servicio que consume servicio del core para usar en capas frontend 
consume servicios rest para obtener datos, realiza validaciones en los request para evitar
enviar datos malos a la capa core. 

Este proyecto simula el proceso de la arquitectura orientada a servicios, la capa de base de datos
que separa del frontend y un orquestador usa sus servicios para obtener datos las validaciones 
de datos de entrada le corresponde al orquestador

Path principal http://localhost:8081/v1/orquestador-shop/
para consumo de servicios

Ejemplo consumo para crear productos 
http://localhost:8081/v1/orquestador-shop/create-productos peticion POST
{
    "descripcion": "azur",
    "existencia": "1",
    "nombre": "anillo",
    "precio":600.00
}
Ejemplos de operaciones
crear cliente
http://localhost:8081/v1/orquestador-shop/create-cliente
Lista productos
http://localhost:8081/v1/orquestador-shop/list-productos




Application.properties contiene parametros de configuracion como el path de inicio del proyecto, mapear los endpoint del core
y puerto de inicio de la applicacion spring boot
