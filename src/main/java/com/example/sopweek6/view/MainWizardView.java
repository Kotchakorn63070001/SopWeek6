package com.example.sopweek6.view;

import com.example.sopweek6.pojo.Wizard;
import com.example.sopweek6.pojo.Wizards;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "/mainPage.it")
public class MainWizardView extends VerticalLayout {
    private TextField fullname, dollars;
    private RadioButtonGroup<String> gender;
    private ComboBox position, school, house;
    private Button btnBefore, btnCreate, btnUpdate, btnDel, btnAfter;
    private HorizontalLayout panel;
    private Wizards wizards = new Wizards();
    private int num = 0;

    public MainWizardView() {
        fullname = new TextField();
        fullname.setPlaceholder("Fullname");
//        fullname.setValue(String.valueOf(wizards.model.get(0).getName() ));
        gender = new RadioButtonGroup<>();
        gender.setLabel("Gender :");
        gender.setItems("Male", "Female");
        position = new ComboBox();
        position.setPlaceholder("Position");
        position.setItems("Student", "Teacher");
        dollars = new TextField("Dollars");
        dollars.setPrefixComponent(new Div(new Text("$")));
        school = new ComboBox();
        school.setPlaceholder("School");
        school.setItems("Hogwarts", "Beauxbatons", "Durmstrang");
        house = new ComboBox();
        house.setPlaceholder("House");
        house.setItems("Gryffindor", "Ravenclaw", "Hufflepuff", "Slyther");
        btnBefore = new Button("<<");
        btnCreate = new Button("Create");
        btnUpdate = new Button("Update");
        btnDel = new Button("Delete");
        btnAfter = new Button(">>");
        panel = new HorizontalLayout();
        panel.add(btnBefore, btnCreate, btnUpdate, btnDel, btnAfter);
        add(fullname, gender, position, dollars, school, house, panel);


        btnCreate.addClickListener(event -> {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("sex",  gender.getValue());
            formData.add("name", fullname.getValue());
            formData.add("school", school.getValue().toString());
            formData.add("house", house.getValue().toString());
            formData.add("money", dollars.getValue());
            formData.add("position", position.getValue().toString());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addWizard")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            System.out.println(out);
        });


//        btnBefore.addClickListener(event -> {
//            if(num==1){
//                num++;
//            }
//            else{
//                fullname.setValue(wizards.model.get(num-2).getName());
////                gender.setValue(wizards.model.get(num-2).getSex());
//            }
//            num--;
//        });
//
        btnAfter.addClickListener(event -> {
            System.out.println(wizards.model);
//            num++;
//            fullname.setValue(wizards.model.get(num).getName());
        });
    }
}
