package br.com.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundo {
    public static void main(String[] args) {
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
        //System.out.println(response.getBody().asString());
        System.out.println(response.getBody().asString().equals("Ola Mundo!"));
        //System.out.println(response.statusCode());
        System.out.println(response.statusCode() == 200);

        ValidatableResponse validacao = response.then();
        //caso o status code não seja igual ele retorna uma exceção
        validacao.statusCode(200);
    }
}
