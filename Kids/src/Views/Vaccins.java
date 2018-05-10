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
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
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
    Label descreiptionLabel;
    Label effetnegatifLabel;
    VaccinService vservice = new VaccinService();
    
    

 public Form InitInterface()
    {
            
            ArrayList<Vaccine> lst = vservice.getList();
            Container list = new Container (BoxLayout.y());
            list.setScrollableY(true);
            for(Vaccine s : lst) {
                Button b = new Button(s.getName());
                idLabel = new Label(String.valueOf(s.getId()));
                nameLabel = new Label("name :"+s.getName());
                ageLabel = new Label("age :"+String.valueOf(s.getAge()));
                descreiptionLabel = new Label("description :"+s.getDescription());
                effetnegatifLabel = new Label("effet negatif :"+s.getEffetnegatif());
                list.add(idLabel);
                list.add(nameLabel);
                list.add(ageLabel);
                list.add(descreiptionLabel);
                list.add(effetnegatifLabel);
                try {
                Label i = new Label();
                Image img = Image.createImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuxRj0cAi1nyQT25Rg1LvRa4rIvUNRXuTdHlHPLUIXYE9UxAXU");
                i.setIcon(img);
                } catch (Exception e) {
                }
                
                b.addActionListener(e -> Log.p("You picked: " + b.getText()));
            }
            Form f = new Form();
            f.add(list);
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
        return descreiptionLabel;
    }

    public void setDescreiptionLabel(Label descreiptionLabel) {
        this.descreiptionLabel = descreiptionLabel;
    }

    public Label getEffetnegatifLabel() {
        return effetnegatifLabel;
    }

    public void setEffetnegatifLabel(Label effetnegatifLabel) {
        this.effetnegatifLabel = effetnegatifLabel;
    }
    

 
 
 
 
    
}
