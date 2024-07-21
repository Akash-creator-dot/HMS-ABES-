package com.techgiants.hmsabes;

public class RoomnumberStracture {
    String name,seater,vacant;

    public RoomnumberStracture(String name,String seater,String vacant) {
        this.name = name;
        this.seater=seater;
        this.vacant=vacant;

    }

    public String getname() {
        return name;
    }
    public String getseater() {
        return seater;
    }
    public String getvacant() {
        return vacant;
    }

}
