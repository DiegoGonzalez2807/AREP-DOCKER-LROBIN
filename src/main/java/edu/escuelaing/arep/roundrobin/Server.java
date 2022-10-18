/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.escuelaing.arep.roundrobin;

import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.Spark.*;
/**
 *
 * @author diego
 */
public class Server {

    public static void main(String[] args) {
        port(getPort());
        //Conexion con base de datos
        staticFiles.location("/public");
        System.out.println("Initializing...");

        //Primer PATH, se encarga de la redireccion a la pagina principal
        get("/inicio", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });
        //Path para consulta vacia que puede hacer la implementacion
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });
    }
    /**
     * Funcion generada para generar un puerto por defecto
     * para conectarse a la aplicacion web
     * @return
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
