package com.example.acco;

public class llista_aedl {

    private String ordre;
    private String poble;
    private String direccio;
    private String email;
    private String telefon;
    private int ipPhoto;

    public llista_aedl(String ordre, String poble, String direccio, String email, String telefon, int ipPhoto) {
        this.ordre = ordre;
        this.poble = poble;
        this.direccio = direccio;
        this.email = email;
        this.telefon = telefon;
        this.ipPhoto = ipPhoto;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getPoble() {
        return poble;
    }

    public void setPoble(String poble) {
        this.poble = poble;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getIpPhoto() {
        return ipPhoto;
    }

    public void setIpPhoto(int ipPhoto) {
        this.ipPhoto = ipPhoto;
    }

    @Override
    public String toString() {
        return "llista_aedl{" +
                "ordre='" + ordre + '\'' +
                ", poble='" + poble + '\'' +
                ", direccio='" + direccio + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", ipPhoto=" + ipPhoto +
                '}';
    }
}

