# Mutantes

La aplicacion se encuentra realizada en java. Como Framework se elegio Spring Boot, para correr la aplicacion solo se recomienda hacer lo siguiente:

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
4. En el archivo appication.properties se encuentras las configuraciones de la base de datos, tales como:
Nombre, usuario, puerto y contraseña. Las cuales deben ser cambiadas al momento de su ejecucion local

![image](https://user-images.githubusercontent.com/31300075/187099381-d39c3f8d-c343-4c14-9ce1-272aa922ee62.png)

Nota: Para verificar la cobertura del 80% se debe dirigir a la carpeta site/jacoco. En este lugar se encuentra el reporte de coberturas. 
