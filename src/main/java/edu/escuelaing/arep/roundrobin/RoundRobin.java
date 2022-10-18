package edu.escuelaing.arep.roundrobin;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;


import static spark.Spark.*;

public class RoundRobin {

    String service1 = "";
    String service2 = "";
    String service3 = "";
    String url = service1;
    private int numberServer = 0;

    /**
     * Funcion generada para retornar las 10 ultimas cadenas de la base Mongo
     * @param chainValue
     * @return
     * @throws UnirestException
     */
    public String getChains(String chainValue) throws UnirestException{
        HttpResponse<String> proof = Unirest.get(url+"/insert/"+chainValue).asString();
        return String.valueOf(proof);
    }
    
    /**
     * Funcion generada para hacer cambio de servidor de acuerdo con un contador
     */
    public void changeServer(){
        numberServer +=1;
        switch (numberServer){
            case 1:
                url = service1;
                break;
            case 2:
                url = service2;
                break;
            case 3:
                url = service3;
                numberServer = 0;
                break;
        }
    }

}
