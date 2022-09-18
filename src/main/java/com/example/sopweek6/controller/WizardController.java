package com.example.sopweek6.controller;

import com.example.sopweek6.pojo.Wizard;
import com.example.sopweek6.pojo.Wizards;
import com.example.sopweek6.repository.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WizardController {
    @Autowired
    private WizardService wizardService;
    protected Wizards wizards = new Wizards();
    @RequestMapping(value = "/wizards", method = RequestMethod.GET)
    public ResponseEntity<?> getWizards(){
        List<Wizard> wizard = wizardService.retrieveWizards();
        wizards.model = (ArrayList<Wizard>) wizardService.retrieveWizards();
        return ResponseEntity.ok(wizard);
    }

//    @RequestMapping(value = "/wizardsArray", method = RequestMethod.GET)
//    public ArrayList<Wizard> getWizardsList(){
//        return wizards.model;
//    }

    @RequestMapping(value = "/addWizard", method = RequestMethod.POST)
    public ResponseEntity<?> addWizard(@RequestParam("sex") String sex,
                                       @RequestParam("name") String name,
                                       @RequestParam("school") String school,
                                       @RequestParam("house") String house,
                                       @RequestParam("money") int money,
                                       @RequestParam("position") String position){
        Wizard n = wizardService.createWizard(new Wizard(null, sex, name, school, house, money, position));
        return ResponseEntity.ok(n);
    }




}
