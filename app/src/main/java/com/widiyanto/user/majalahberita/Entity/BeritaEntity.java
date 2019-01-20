package com.widiyanto.user.majalahberita.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeritaEntity {

    @SerializedName("status")
    @Expose
    String  status ;
    @SerializedName("totalResults")
    @Expose
    String totalresults;
    @SerializedName("articles")
    @Expose
    List<BeritaArtikelData> artikelData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public List<BeritaArtikelData> getArtikelData() {
        return artikelData;
    }

    public void setArtikelData(List<BeritaArtikelData> artikelData) {
        this.artikelData = artikelData;
    }
}
