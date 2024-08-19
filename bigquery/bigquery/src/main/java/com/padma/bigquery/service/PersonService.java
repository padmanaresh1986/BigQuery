package com.padma.bigquery.service;

import com.google.cloud.bigquery.TableResult;
import com.padma.bigquery.client.BigQueryClient;
import com.padma.bigquery.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private BigQueryClient bigQueryClient;

    public List<Person> getAllPersons(){
        String query = "put your select query here";
        TableResult result = bigQueryClient.query(query);
        List<Person> personList = new ArrayList<>();
        result.iterateAll().forEach(item ->{
            String firstName = item.get("firstName").getStringValue();
            String lastName = item.get("lastName").getStringValue();
            personList.add(new Person(firstName,lastName));
        });
        return personList;
    }

}
