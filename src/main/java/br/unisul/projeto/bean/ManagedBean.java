package br.unisul.projeto.bean;

public class ManagedBean {

    public boolean disable;

    // default constructor 
    public ManagedBean(){
       this.disable= false;
    }

    public boolean isDisable() {
       return disable;
    }
    public void setDisable(boolean disable) {
       this.disable = disable;
    }


}
