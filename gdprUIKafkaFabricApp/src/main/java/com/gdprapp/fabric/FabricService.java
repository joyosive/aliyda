package com.gdprapp.fabric;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdprapp.fabric.model.Address;
import com.gdprapp.fabric.model.Grower;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricService {


    public static final String SERVER_URI = "http://localhost:3000/api";

    public List<Grower> getAllGrowers(){

        List<Grower> result = new ArrayList<Grower>();

        RestTemplate restTemplate = new RestTemplate();

        String url = SERVER_URI+"/Grower";

        ResponseEntity<List<Grower>> rateResponse = restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<Grower>>() {});

        if (rateResponse.getBody() != null){
            result = rateResponse.getBody();
        }


        return result;
    }


    public String addGrower(String email,Long amount) throws JsonProcessingException {

        String result = new String();

        Grower grower = new Grower();
        grower.setEmail(email);
        grower.setAccountBalance(amount);
        Address address = new Address();
        address.setCity("delhi");
        address.setCountry("india");
        address.setStreet("pitampura");
        address.setZip("110034");
        grower.setAddress(address);
        ObjectMapper mapper = new ObjectMapper();

        String requestJson = mapper.writeValueAsString(grower);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        String url = SERVER_URI+"/Grower";

        ResponseEntity<String> rateResponse = restTemplate.exchange(url, HttpMethod.POST,entity,String.class);

        if (rateResponse.getBody() != null){
            result = rateResponse.getBody();
        }


        return result;
    }


}
