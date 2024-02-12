
package testDataTypes;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;


@Data
public class Address {

    private String streetAddress;
    private String city;
    private String postCode;
    private String state;
    private String country;
    private String county;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}
