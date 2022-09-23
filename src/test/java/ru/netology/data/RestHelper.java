package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import lombok.experimental.UtilityClass;

import static io.restassured.RestAssured.given;

@UtilityClass
public class RestHelper {

    public String pathBuyPage = "/api/v1/payment";
    public String pathCreditPage = "/api/v1/credit";

    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String sendFormBuy(DataGenerator.OwnerInfo ownerInfo) {
        return given()
                .spec(requestSpec)
                .body(ownerInfo)
                .when()
                .post(pathBuyPage)
                .then()
                .statusCode(200)
                .extract().response().asString();
    }

    public static String sendFormCredit(DataGenerator.OwnerInfo ownerInfo) {
        return given()
                .spec(requestSpec)
                .body(ownerInfo)
                .when()
                .post(pathCreditPage)
                .then()
                .statusCode(200)
                .extract().response().asString();
    }
}
