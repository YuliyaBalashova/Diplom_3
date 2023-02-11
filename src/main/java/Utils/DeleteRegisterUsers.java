package Utils;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteRegisterUsers {
    private final String email;
    private final String password;

    public DeleteRegisterUsers(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void deleteUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        String token = given()
                .log().all()
                .header("Content-type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .when()
                .post("/api/auth/login")
                .then()
                .log().all()
                .extract().body().jsonPath().get("accessToken");

        given()
                .log().all()
                .auth().oauth2(token.substring(7))
                .header("Content-type", "application/json")
                .delete("/api/auth/user")
                .then()
                .log().all();
    }
}