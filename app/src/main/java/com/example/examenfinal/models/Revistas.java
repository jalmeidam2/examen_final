package com.example.examenfinal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Revistas {
    @SerializedName("journal_id")
    @Expose
    private String journal_id;
    @SerializedName("portada")
    @Expose
    private String portada;
    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("journalThumbnail")
    @Expose
    private String journalThumbnail;
    @SerializedName("name")
    @Expose
    private String name;

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJournalThumbnail() {
        return journalThumbnail;
    }

    public void setJournalThumbnail(String journalThumbnail) {
        this.journalThumbnail = journalThumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
