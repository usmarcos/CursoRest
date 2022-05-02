package br.com.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class OlaMundoTest {
    @Test
    public void testeOlaMundo(){
        //importante RestAssured para usar request
        Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertEquals(response.statusCode(), 200);

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }

    @Test
    public void outrasFormas(){
        Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

       //importando o RestAssured
       //RestAssured.get("http://restapi.wcaquino.me/ola").then().statusCode(200);
        get("http://restapi.wcaquino.me/ola").then().statusCode(200);

        // pode se utilizar o GIVEN WHEN THEN
        //pré-condição > ação (para esse exemplo = get) > assertivas (o que será testado)
        given().when().get("http://restapi.wcaquino.me/ola").then().statusCode(200);

        // ou para melhorar a visualização pode-se quebrar linhas
        given()
                //pré condições, caso não tenha colocar para manter um padrão
        .when()
                .get("http://restapi.wcaquino.me/ola")
        .then()
                .statusCode(200);
    }

}
