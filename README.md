# BACKEND DE TEC MATCH
## Documentación de la API
### Tipos de Sockets
| Método | Ruta                                        | Descipción                                                                               | Body             |
|--------|---------------------------------------------|------------------------------------------------------------------------------------------|------------------|
| POST   | /api/v1/tipos-socket                        | Crea un tipo de socket                                                                   | {nombre:String}  |
| GET    | /api/v1/tipos-socket                        | Obtiene todos los tipos de socket                                                        | ---------------  |
| GET    | /api/v1/tipos-socket/{id}                   | Obtiene un tipo de socket por ID                                                         | ---------------  |
| GET    | /api/v1/tipos-socket/nombre?contains=String | Obtiene tipos de sockets con nombres que contengan el String. (Ignora el case sensitive) | ---------------  |
| PUT    | /api/v1/tipos-socket/{id}                   | Actualiza un tipo de socket existente                                                    | {nombre:String}  |
| DELETE | /api/v1/tipos-socket/{id}                   | Elimina un tipo de socket existente                                                      | ---------------  |
### Sockets
| Método | Ruta                                   | Descipción                                                                      | Body                                   |
|--------|----------------------------------------|---------------------------------------------------------------------------------|----------------------------------------|
| POST   | /api/v1/sockets                        | Crea un socket                                                                  | ![img.png](images/BodySocketPost.png)  |
| GET    | /api/v1/sockets                        | Obtiene todos los socket                                                        | ---------------                        |
| GET    | /api/v1/sockets/{id}                   | Obtiene un socket por ID                                                        | ---------------                        |
| GET    | /api/v1/sockets/nombre?contains=String | Obtiene sockets con nombres que contengan el String. (Ignora el case sensitive) | ---------------                        |
| GET    | /api/v1/sockets/tipo-socket/{id}       | Obtiene sockets con el id de un tipo de socket                                  |                                        |
| PUT    | /api/v1/sockets/{id}                   | Actualiza un socket existente                                                   | {nombre:String}                        |
| DELETE | /api/v1/sockets/{id}                   | Elimina un socket existente                                                     | ---------------                        |
### Fabricantes
| Método | Ruta                                        | Descipción                                                                          | Body             |
|--------|---------------------------------------------|-------------------------------------------------------------------------------------|------------------|
| POST   | /api/v1/tipos-socket                        | Crea un fabricante                                                                  | {nombre:String}  |
| GET    | /api/v1/tipos-socket                        | Obtiene todos los fabricantes                                                       | ---------------  |
| GET    | /api/v1/tipos-socket/{id}                   | Obtiene un fabricante por ID                                                        | ---------------  |
| GET    | /api/v1/tipos-socket/nombre?contains=String | Obtiene fabricantes con nombres que contengan el String. (Ignora el case sensitive) | ---------------  |
| PUT    | /api/v1/tipos-socket/{id}                   | Actualiza un fabricante existente                                                   | {nombre:String}  |
| DELETE | /api/v1/tipos-socket/{id}                   | Elimina un fabricante existente                                                     | ---------------  |
### Piezas
| Método | Ruta                                  | Descipción                                                                     | Body                                  |
|--------|---------------------------------------|--------------------------------------------------------------------------------|---------------------------------------|
| POST   | /api/v1/piezas                        | Crea una piezas                                                                | ![img.png](images/BodyPiezaPost.png)  |
| GET    | /api/v1/piezas                        | Obtiene todas las piezas                                                       | ---------------                       |
| GET    | /api/v1/piezas/{id}                   | Obtiene una pieza por ID                                                       | ---------------                       |
| GET    | /api/v1/piezas/nombre?contains=String | Obtiene piezas con nombres que contengan el String. (Ignora el case sensitive) | ---------------                       |
| GET    | /api/v1/piezas/modelo?contains=String | Obtiene piezas con modelos que contengan el String. (Ignora el case sensitive) | ---------------                       |
| GET    | /api/v1/piezas/precio?lessThan=Float  | Obtiene piezas cuyo precio sean menores al Float                               | ---------------                       |
| GET    | /api/v1/piezas/voltaje?voltaje=Float  | Obtiene piezas cuyo voltaje sean iguales al Float                              | ---------------                       |
| GET    | /api/v1/piezas/socket/{id}            | Obtiene piezas con el id de su socket                                          | ---------------                       |
| GET    | /api/v1/piezas/fabricante/{id}        | Obtiene piezas con el id de su fabricante                                      | ---------------                       |
| PUT    | /api/v1/piezas/{id}                   | Actualiza una pieza existente                                                  | ![img.png](images/BodyPiezaPut.png)   |
| DELETE | /api/v1/piezas/{id}                   | Elimina una pieza existente                                                    | ---------------                       |
### Usuarios
| Método | Ruta                   | Descipción                                  | Body                                    |
|--------|------------------------|---------------------------------------------|-----------------------------------------|
| POST   | /api/v1/usuarios       | Crea un usuario                             | ![img.png](images/BodyUsuarioPost.png)  |
| POST   | /api/v1/usuarios/login | Logea a un usuario verificando credenciales | ![img.png](images/BodyUsuarioLogin.png) |
| GET    | /api/v1/usuarios       | Obtiene todos los usuarios                  | ---------------                         |
| GET    | /api/v1/usuarios/{id}  | Obtiene un usuario por ID                   | ---------------                         |
| PUT    | /api/v1/usuarios/{id}  | Actualiza un usuario existente              | ![img.png](images/BodyUsuarioPut.png)   |
| DELETE | /api/v1/usuarios/{id}  | Elimina un usuario existente                | ---------------                         |
**¡CONSIDERACIÓN IMPORTANTE!: Por ahora al usuario solo se le puede actualizar el correo y el nombre de usuario**
### RAMs
| Método | Ruta                     | Descipción                                            | Body                               |
|--------|--------------------------|-------------------------------------------------------|------------------------------------|
| POST   | /api/v1/RAMs             | Crea una RAM                                          | ![img.png](images/BodyRamPost.png) |
| GET    | /api/v1/RAMs             | Obtiene todas las RAMS                                | ---------------                    |
| GET    | /api/v1/RAMs/{id}        | Obtiene una RAM por ID                                | ---------------                    |
| GET    | /api/v1/RAMs/pieza/{id}  | Obtiene una RAM por el ID de la Pieza                 | ---------------                    |
| PUT    | /api/v1/RAMs/{id}        | Actualiza una RAM existente **(NO IMPLEMENTADO AÚN)** | vacío por el momento               |
| DELETE | /api/v1/RAMs/{id}        | Elimina una RAM existente                             | ---------------                    |
