package com.example.eslive20240829.entities;

// le entità ci permettono di lavorare meglio con i dati
public class Languages {
    // evitare le String perché l'inserimento libero di testo può portare ad errori
    private Integer id; // l'id ci deve essere sempre
    private String language; // questo potrebbe essere un enumerato
    private String nation; // questo potrebbe essere un enumerato o un'entità a parte

    public Languages(Integer id, String language, String nation) {
        this.id = id;
        this.language = language;
        this.nation = nation;
    }

    public Integer getId() {
        return id;
    }

    // L'id NON deve essere cambiato mai
    /*public void setId(Integer id) {
        this.id = id;
    }*/

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
