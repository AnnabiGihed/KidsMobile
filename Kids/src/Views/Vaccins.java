/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Vaccine;
import Services.VaccinService;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.ComponentSelector.$;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.table.TableLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mmsalemi
 */
public class Vaccins extends Form{

    Label idLabel;
    Label nameLabel;
    Label ageLabel;
    Label descriptionLabel;
    Label effetnegatifLabel;
    Label priceLabel;
    VaccinService vservice = new VaccinService();
    
    
    private Label createSeparator() {
        Label sep = new Label();
        sep.setTextPosition(Component.RIGHT);
        sep.setUIID("Separator");
        sep.setShowEvenIfBlank(true);
        return sep;
    }
    

 public Form InitInterface()
    {
             ArrayList<Vaccine> lst = vservice.getList();
            Container ContainerVaccins = new Container (BoxLayout.y());
            for(Vaccine s : lst) {
                
        Label iconInjection = new Label();  
        iconInjection.setTextPosition(Component.RIGHT);
        iconInjection.setUIID("iconInjection");
        iconInjection.setShowEvenIfBlank(true);
                
                
                
                Button b = new Button(s.getName());
                Container c = new Container(new BorderLayout());
                idLabel = new Label(String.valueOf(s.getId()));
                idLabel.setUIID("IdLabel");
                priceLabel = new Label(String.valueOf(s.getPrice()) +" TND");
                priceLabel.setUIID("priceLabel");
                nameLabel = new Label(s.getName());
                nameLabel.setUIID("nameLabel");
                
                
              
                
                c.addComponent(BorderLayout.WEST, nameLabel);
                c.addComponent(BorderLayout.EAST, priceLabel);
                ageLabel = new Label("Age : "+String.valueOf(s.getAge())+ " mois");
                ageLabel.setUIID("ageLabel");
                descriptionLabel = new Label(s.getDescription().substring(0,55)+"...");
                descriptionLabel.setUIID("descriptionLabel");
                effetnegatifLabel = new Label("effet negatif :"+s.getEffetnegatif());
                effetnegatifLabel.setUIID("effetnegativeLabel");
                Label separator = this.createSeparator();
                ContainerVaccins.add(c);
                ContainerVaccins.add(ageLabel);
                ContainerVaccins.add(descriptionLabel);
                ContainerVaccins.add(separator);
                
                try {
                Label i = new Label();
                Image img = Image.createImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuxRj0cAi1nyQT25Rg1LvRa4rIvUNRXuTdHlHPLUIXYE9UxAXU");
                i.setIcon(img);
                } catch (Exception e) {
                }
                
                b.addActionListener(e -> Log.p("You picked: " + b.getText()));
            }
            Form f = new Form("Liste des vaccins", new FlowLayout());
            f.add(ContainerVaccins);
            return f;
    }
    
    
 
 
     public Vaccins(String title) 
    {
        super(title);
        InitInterface();
    }

    public Vaccins(Layout contentPaneLayout) 
    {
        super(contentPaneLayout);
        InitInterface();
    }

    public Vaccins(String title, Layout contentPaneLayout) 
    {
        super(title, contentPaneLayout);
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
