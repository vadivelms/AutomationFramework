
package testDataTypes;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
@Data
public class Customer {

    private String firstName;
    private String lastName;
    private Integer age;
    private String emailAddress;
    private Address address;
    private PhoneNumber phoneNumber;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
}
