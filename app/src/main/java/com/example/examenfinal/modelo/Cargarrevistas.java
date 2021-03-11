package com.example.examenfinal.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cargarrevistas {

    private String journal_id;
    private  String name;
    private String portada;
    private String abbreviation;
    private String descripcion;

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Cargarrevistas(String journal_id, String name, String portada, String abbreviation, String descripcion) {
        this.journal_id = journal_id;
        this.name = name;
        this.portada = portada;
        this.abbreviation = abbreviation;
        this.descripcion = descripcion;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cargarrevistas(JSONObject json) throws JSONException
    {
        name = json.getString("name").toString();
        descripcion = json.getString("description").toString();
        portada = json.getString("portada").toString();
        abbreviation = json.getString("abbreviation").toString();
        journal_id = json.getString("journal_id").toString();
    }
    public static ArrayList<Cargarrevistas> jsonObjectsBuild(JSONArray recorrer) throws JSONException
    {
        ArrayList<Cargarrevistas> listarRevistas = new ArrayList<>();
        for (int i=0; i<recorrer.length();i++)
        {
            listarRevistas.add(new Cargarrevistas(recorrer.getJSONObject(i)));
        }

        return  listarRevistas;
    }
}
