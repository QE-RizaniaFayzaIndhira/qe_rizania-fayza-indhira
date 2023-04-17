package starter.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class POST_a_new_user {
    public String POST_endpoint_new_user = "https://fakestoreapi.com/users";
    public String POST_invalid_endpoint_new_user = "https://fakestoreapi.com//users";

    @Step("user set POST endpoint for new user")
    public String setPostEndpointForNewUser(){
    return POST_endpoint_new_user;
    }

    @Step("user send POST HTTP request for new user")
    public void sendPOSTHTTPRequestForNewUser(){
    String body = "{ " +
        "\"email\":\"John@gmail.com\", \"username\": \"johnd\", \"password\":\"m38rmF$\", " +
      "\"name\" : { " +
            "\"firstname\": \"John\", " +
            "\"lastname\": \"Doe\"}," +
      "\"address\" : { " +
            "\"city\": \"kilcoole\", " +
            "\"street\": \"7835 new road\"," +
            "\"number\": \"3\"," +
            "\"zipcode\": \"12926-3874\"," +
            "\"geolocation\" : { " +
                "\"lat\": \"-37.3159\", " +
                "\"long\": \"81.1496\"} }," +
      "\"phone\": \"1-570-236-7033\" }";

      JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointForNewUser());
    }

    @Step("user received HTTP response code 200 for new user")
    public void validateHTTPResponseCode200ForNewUser(){
        restAssuredThat(response -> response.statusCode(200));

     }

    @Step("user set POST endpoint with invalid query parameter for new user")
    public String setPostEndpointWithInvalidQueryParameterForNewUser(){
      return POST_invalid_endpoint_new_user;
    }

    @Step("user send POST HTTP request with invalid query parameter for new user")
    public void sendPOSTHTTPRequestWithInvalidQueryParameterForNewUser(){
      String body = "{\"email\":\"John@gmail.com\", \"username\": \"johnd\",\"password\":\"m38rmF$\", " +
            "\"firstname\": \"John\", \"lastname\": \"Doe\", \"city\": \"kilcoole\", \"street\": \"7835 new road\"," +
          "\"number\": \"3\", \"zipcode\": \"12926-3874\",\"lat\": \"-37.3159\", \"long\": \"81.1496\", " +
        "\"phone\": \"1-570-236-7033\" }";

    JSONObject reqBody = new JSONObject(body);

    SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointWithInvalidQueryParameterForNewUser());
    }

    @Step("user received POST HTTP response code 404 for new user")
    public void validatePOSTHTTPResponseCode404ForNewUser(){
      restAssuredThat(response -> response.statusCode(404));
    }
    @Step("user received valid data for new user")
    public void validateValidNewUser(){

        restAssuredThat(response->response.body("'email'",equalTo("John@gmail.com")));
        restAssuredThat(response->response.body("'username'",equalTo("johnd")));
        restAssuredThat(response->response.body("'password'",equalTo("m38rmF$")));
        restAssuredThat(response->response.body("'name.firstname'",equalTo("John")));
        restAssuredThat(response->response.body("'address.city'",equalTo("kilcoole")));
        restAssuredThat(response->response.body("'address.street'",equalTo("7835 new road")));
        restAssuredThat(response->response.body("'address.number'",equalTo("3")));
        restAssuredThat(response->response.body("'address.zipcode'",equalTo("12926-3874")));
        restAssuredThat(response->response.body("'address.geolocation.lat'",equalTo("-37.3159")));
        restAssuredThat(response->response.body("'address.geolocation.long'",equalTo("81.1496")));
        restAssuredThat(response->response.body("'phone'",equalTo("1-570-236-7033")));
    }
}
