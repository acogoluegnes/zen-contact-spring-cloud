package com.zenika;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Created by acogoluegnes on 02/09/15.
 */
@Repository
public class ContactRepository {

    @Autowired
    RestTemplate restClient;

    public ContactsResponse contacts() {
        ContactsResponse response = restClient.getForObject("http://backend-service/contacts", ContactsResponse.class);
        response.setOk(true);
        return response;
    }

    public ContactsResponse contactsFailure() {
        return new ContactsResponse("local",false,new ArrayList<Contact>()
        );
    }



}
