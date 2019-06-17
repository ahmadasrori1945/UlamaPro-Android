package id.co.telkomsigma.ulamapro.model;

public class ModelQuran {
    String nama;
    String asma;
    String ayat;
    String arti;
    String nomor;



    public ModelQuran(String nama, String asma, String ayat, String arti, String nomor) {
        this.nama = nama;
        this.asma = asma;
        this.ayat = ayat;
        this.arti = arti;
        this.nomor = nomor;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }
}
