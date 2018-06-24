/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Vaccine;
import Services.EventService;
import Services.VaccinService;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.util.ArrayList;

/**
 *
 * @author MARWEN
 */
public class Vaccins extends Form{

    Label idLabel;
    Label nameLabel;
    Label ageLabel;
    Label descriptionLabel;
    Label effetnegatifLabel;
    Label priceLabel;
    VaccinService vservice = new VaccinService();
    Form PreviousForm;
    
    
    private Label createSeparator() {
        Label sep = new Label();
        sep.setTextPosition(Component.RIGHT);
        sep.setUIID("Separator");
        sep.setShowEvenIfBlank(true);
        return sep;
    }
    

 public Form InitInterface()
    {
        Label separator = new Label("", "BlueSeparatorLine");

        EventService test = new EventService();
        ArrayList<Vaccine> lst = vservice.getList();
        Container ContainerVaccins = new Container(BoxLayout.y());
        for (Vaccine s : lst) {

            Label iconInjection = new Label();
            iconInjection.setTextPosition(Component.RIGHT);
            iconInjection.setUIID("iconInjection");
            iconInjection.setShowEvenIfBlank(true);

            Button b = new Button(s.getName());
            Container c = new Container(new BorderLayout());
            idLabel = new Label(String.valueOf(s.getId()));
            idLabel.setUIID("IdLabel");
            priceLabel = new Label(String.valueOf(s.getPrice()) + " TND");
            priceLabel.setUIID("priceLabel");
            nameLabel = new Label(s.getName());
            nameLabel.setUIID("nameLabel");

            c.addComponent(BorderLayout.WEST, nameLabel);
            c.addComponent(BorderLayout.EAST, priceLabel);
            ageLabel = new Label("Age : " + String.valueOf(s.getAge()) + " mois");
            ageLabel.setUIID("ageLabel");
            descriptionLabel = new Label(s.getDescription());
            descriptionLabel.setUIID("descriptionLabel");
            effetnegatifLabel = new Label("effet negatif :" + s.getEffetnegatif());
            effetnegatifLabel.setUIID("effetnegativeLabel");
            ContainerVaccins.add(c);
            ContainerVaccins.add(ageLabel);
            ContainerVaccins.add(descriptionLabel);
            ContainerVaccins.add("______________________________");

            b.addActionListener(e -> Log.p("You picked: " + b.getText()));
        }
        Form f = new Form("Liste des vaccins", new FlowLayout());
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, s);
        f.getToolbar().addCommandToLeftBar("", icon, (e) -> PreviousForm.showBack());
        f.add(ContainerVaccins);
        return f;
    }
    
    
 
 
     public Vaccins(String title, Form PreviousForm) 
    {
        super(title);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public Vaccins(Layout contentPaneLayout, Form PreviousForm) 
    {
        super(contentPaneLayout);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public Vaccins(String title, Layout contentPaneLayout, Form PreviousForm) 
    {
        super(title, contentPaneLayout);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public Vaccins() {
       
    }


    public VaccinService getVservice() {
        return vservice;
    }

    public void setVservice(VaccinService vservice) {
        this.vservice = vservice;
    }

    public Label getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(Label idLabel) {
        this.idLabel = idLabel;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public Label getAgeLabel() {
        return ageLabel;
    }

    public void setAgeLabel(Label ageLabel) {
        this.ageLabel = ageLabel;
    }

    public Label getDescreiptionLabel() {
        return descriptionLabel;
    }

    public void setDescreiptionLabel(Label descreiptionLabel) {
        this.descriptionLabel = descreiptionLabel;
    }

    public Label getEffetnegatifLabel() {
        return effetnegatifLabel;
    }

    public void setEffetnegatifLabel(Label effetnegatifLabel) {
        this.effetnegatifLabel = effetnegatifLabel;
    }
    

 
 
 
 
    
}
