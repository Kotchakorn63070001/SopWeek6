package com.example.sopweek6.repository;

import com.example.sopweek6.pojo.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WizardService {
    @Autowired
    private WizardRepository repository;

    public WizardService(WizardRepository repository) {
        this.repository = repository;
    }

    public List<Wizard> retrieveWizards(){
        return repository.findAll();
    }

    public Wizard createWizard(Wizard wizard){
        return repository.save(wizard);
    }

}
