package id.co.telkomsigma.ulamapro.model;

public class modelTahlil {

    String nama;
    String no;
    String isi;
    String surat;

    public modelTahlil(String nama, String no, String isi, String surat) {
        this.nama = nama;
        this.no = no;
        this.isi = isi;
        this.surat = surat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getSurat() {
        return surat;
    }

    public void setSurat(String surat) {
        this.surat = surat;
    }
}
