package entities;

import java.text.SimpleDateFormat;

public class ImportedProduct extends Product{

    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    private Double totalPrice(){
        return super.getPrice();
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public String priceTag(){
        return super.getPrice().toString() + " (Customs Fee: "+ getCustomsFee() + ")"  ;
    }

}
