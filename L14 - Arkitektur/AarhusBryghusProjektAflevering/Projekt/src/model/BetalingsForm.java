package model;

public class BetalingsForm {
    private BetalingsformerEnum betalingsformerEnum;

    private int antal;

    //--------------------------

    //--------------------------
    BetalingsForm(BetalingsformerEnum betalingsformerEnum, int antal) { //packagevisibility
        this.betalingsformerEnum = betalingsformerEnum;
//        this.enhed = enhed;
        this.antal = antal;
    }

    public BetalingsformerEnum getBetalingsformerEnum() {
        return betalingsformerEnum;
    }

    public void setBetalingsformerEnum(BetalingsformerEnum betalingsformerEnum) {
        this.betalingsformerEnum = betalingsformerEnum;
    }

//    public String getEnhed() {
//        return enhed;
//    }
//
//    public void setEnhed(String enhed) {
//        this.enhed = enhed;
//    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    @Override
    public String toString() {
        return "BetalingsForm{" +
                "betalingsformerEnum=" + betalingsformerEnum +
                ", antal=" + antal +
                '}';
    }
}
