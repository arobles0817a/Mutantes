# Mutantes
 
La aplicacion se encuentra implementada en Java. Se trabajo en el framework spring boot: Se contempla dos formas de ejecutar la aplicacion. Las cuales son:

1. Se puede hacer uso de la aplicacion en Heroku mediante el siguiente enlace: https://mutantes-aseneg.herokuapp.com/api
2. Ejecucion de manera local, se debe tener en cuenta lo siguiente:
    1. Build with dependencies
    2. Clean And Build
    3. Base de datos realizada en postgresql, version 11. Se anexa el DLL para su ejecucion. 

    CREATE TABLE
        adn_resultado
        (
            adn_id INTEGER DEFAULT nextval('adn_resultado_adn_id_seq'::regclass) NOT NULL,
            adn_texto CHARACTER VARYING(500) NOT NULL,
            adn_is_mutante BOOLEAN,
            PRIMARY KEY (adn_id)
        );


    4. En el archivo application.properties se encuentran las configuraciones de la base de datos, tales como:
    Nombre, usuario, puerto y contraseña.Estas deben ser cambiadas al momento de su ejecucion local, ya que la base de datos no se encuentra alojada en la nube

    ![image](https://user-images.githubusercontent.com/31300075/187099381-d39c3f8d-c343-4c14-9ce1-272aa922ee62.png)

    ![image](https://user-images.githubusercontent.com/31300075/187099576-23e5a601-7803-4340-9378-08376f007259.png)


    Nota: Para verificar la cobertura del 80% se debe dirigir a la carpeta site/jacoco. En este lugar se encuentra el reporte de coberturas.
    La aplicacion tambien se encuentra documentada a nivel de codigo fuente con swagger. Si se quiere hacer uso de esta documentacion se debe colocar la siguiente ruta en el navegador  [localhost:8080/api](http://localhost:8080/api/) o en su defecto https://mutantes-aseneg.herokuapp.com/api
    
    Se anexa imagen de la cobertura y documentacion de la aplicacion:

    ![image](https://user-images.githubusercontent.com/31300075/187100006-2890e1a9-e8bf-4f15-90b5-edc374129c83.png)


    ![image](https://user-images.githubusercontent.com/31300075/187100017-3991a723-dbd0-4ae7-a2e2-2c81caf58e72.png)

