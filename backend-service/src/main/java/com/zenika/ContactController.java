package com.zenika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by acogoluegnes on 02/09/15.
 */
@RestController
public class ContactController {

    @Autowired Environment environment;

    @RequestMapping("/contacts")
    public Map<String,Object> contacts() {
        return new HashMap<String, Object>() {{
            put("origin",environment.getActiveProfiles()[0]);
            put("results",asList(
                    new Contact(1L, "Arnaud", "Cogoluègnes", "arnaud.cogoluegnes@zenika.com"),
                    new Contact(2L, "Carl", "Azoury", "carl.azoury@zenika.com")
            ));
        }};
    }

}
