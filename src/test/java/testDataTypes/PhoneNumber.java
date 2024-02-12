
package testDataTypes;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;


@Data
public class PhoneNumber {

    private String home;
    private String mob;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}
