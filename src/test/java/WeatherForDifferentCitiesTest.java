
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WeatherForDifferentCitiesTest extends Base.Test {

    @ParameterizedTest
    @MethodSource("weatherCitiesProvider")
    @Tag("weather")
    @Tag("cities")
    void validateCityName(String city, String country, String countryId, float lon, float lat) {
        given().spec(getCommonSpec(city, country, countryId))
                .when().get()
                .then().spec(getExpectedCoord(city, lon, lat));
    }

    static Stream<Arguments> weatherCitiesProvider() {
        return Stream.of(
                arguments("London", ",uk", "2643743", -0.1257F, 51.5085F),
                arguments("Oxford", ",uk", "2640729", -1.256F, 51.7522F),
                arguments("Gdańsk", ",pl", "3099434", 18.6464F, 54.3521F)
        );
    }
}
