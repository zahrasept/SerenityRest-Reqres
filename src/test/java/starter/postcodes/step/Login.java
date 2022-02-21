package starter.postcodes.step;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

public class Login {

    public String URLLogin="https://reqres.in/api/login";
    @Step
    public void PostLogin(String email, String password){
        JSONObject data = new JSONObject();
        data.put("email", email);
        data.put("password", password);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .log().all()
                .when()
                .post(URLLogin);
    }
}
