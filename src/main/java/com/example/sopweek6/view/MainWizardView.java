package com.example.sopweek6.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "/mainPage.it")
public class MainWizardView extends VerticalLayout {
    private TextField fullname, dollars;
    private RadioButtonGroup<String> gender;
    private ComboBox position, school, house;
    private Button btnBefore, btnCreate, btnUpdate, btnDel, btnAfter;
    private HorizontalLayout panel;

    public MainWizardView() {
        fullname = new TextField();
        fullname.setPlaceholder("Fullname");
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

    }
}
