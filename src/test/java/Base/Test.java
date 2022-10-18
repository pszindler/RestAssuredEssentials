package Base;

import Config.AppPropertiesSingleton;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.is;

public class Test {

    @BeforeAll
    static void init() {
        AppPropertiesSingleton.getInstance();
    }

    public RequestSpecification getCommonSpec(String city, String country, String countryId) {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("baseUri"))
                .setBasePath(System.getProperty("basePath"))
                .addParam("APPID", System.getProperty("appId"))
                .addParam("q", city + country + countryId)
                .build().filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public ResponseSpecification getExpectedCoord(String city, float lon, float lat) {
        return new ResponseSpecBuilder()
                .expectBody("name", is(city))
                .expectBody("coord.lon", is(lon))
                .expectBody("coord.lat", is(lat))
                .expectStatusCode(200).build();
    }


}
