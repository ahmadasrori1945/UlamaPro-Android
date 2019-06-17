package id.co.telkomsigma.ulamapro.model;

public class ModelIsiQuran {

    String number_ayat;
    String text_ayat;
    String text_indo;

    public String getNumber_ayat() {
        return number_ayat;
    }

    public void setNumber_ayat(String number_ayat) {
        this.number_ayat = number_ayat;
    }

    public String getText_ayat() {
        return text_ayat;
    }

    public void setText_ayat(String text_ayat) {
        this.text_ayat = text_ayat;
    }

    public String getText_indo() {
        return text_indo;
    }

    public void setText_indo(String text_indo) {
        this.text_indo = text_indo;
    }

    public ModelIsiQuran(String number_ayat, String text_ayat, String text_indo) {

        this.number_ayat = number_ayat;
        this.text_ayat = text_ayat;
        this.text_indo = text_indo;
    }
}