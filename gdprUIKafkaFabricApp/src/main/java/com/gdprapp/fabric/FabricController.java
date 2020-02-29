package com.gdprapp.fabric;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.gdprapp.fabric.model.Grower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FabricController {

    @Autowired
    FabricService fabricService;

    @RequestMapping(value = "/getGrowers", method = RequestMethod.GET)
    public List<Grower> getAll(){

        return  fabricService.getAllGrowers();
    }


    @RequestMapping(value = "/addGrower/{email}", method = RequestMethod.GET)
    public String add(@PathVariable("email") String email){

        String result = new String();

        try {
            result = fabricService.addGrower(email,400L);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
