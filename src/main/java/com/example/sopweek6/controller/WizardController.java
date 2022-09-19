package com.example.sopweek6.controller;

import com.example.sopweek6.pojo.Wizard;
import com.example.sopweek6.pojo.Wizards;
import com.example.sopweek6.repository.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class WizardController {
    @Autowired
    private WizardService wizardService;
    protected Wizards wizards = new Wizards();
    @RequestMapping(value = "/wizards", method = RequestMethod.GET)
    public ResponseEntity<?> getWizards(){
        List<Wizard> wizard = wizardService.retrieveWizards();
//        wizards.model = (ArrayList<Wizard>) wizardService.retrieveWizards();
//        wizards.model.addAll(wizardService.retrieveWizards());
        wizards.model.addAll(wizard);
        return ResponseEntity.ok(wizard);
    }




//    @RequestMapping(value = "/wizardsArray", method = RequestMethod.GET)
//    public ArrayList<Wizard> getWizardsList(){
//        return wizards.model;
//    }


    @RequestMapping(value = "/addWizard", method = RequestMethod.POST)
    public ResponseEntity<?> addWizard(@RequestBody MultiValueMap<String, String> n){
        Map<String, String> d = n.toSingleValueMap();
//        String sex = d.get("sex");
        Wizard w = wizardService.createWizard(new Wizard(null, d.get("sex"), d.get("name"), d.get("school"), d.get("house"), Integer.parseInt(d.get("money")), d.get("position")));
        return ResponseEntity.ok(w);
    }




}
