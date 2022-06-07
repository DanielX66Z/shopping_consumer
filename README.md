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
