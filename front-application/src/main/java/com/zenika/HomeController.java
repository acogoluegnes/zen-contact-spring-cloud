package com.zenika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by acogoluegnes on 02/09/15.
 */
@Controller
public class HomeController {

    @Autowired ContactRepository contactRepository;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("response",contactRepository.contacts());
        return "home";
    }


}
