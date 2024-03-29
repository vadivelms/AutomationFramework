package dataProviders;

import managers.FileReaderManager;
import testDataTypes.Customer;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Customer.json";
    private final List<Customer> customerList;

    public JsonDataReader(){
        customerList = getCustomerData();
    }

    private List<Customer> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(customerFilePath));
            Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
            return Arrays.asList(customers);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + customerFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final Customer getCustomerByName(String customerName){
        for(Customer customer : customerList) {
            if(customer.getFirstName().equalsIgnoreCase(customerName)) return customer;
        }
        return null;
    }


}
