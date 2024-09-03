package com.example.eslive20240829.services;

import com.example.eslive20240829.entities.Languages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {
    private List<Languages> languages;

    public HelloService() {
        this.languages = new ArrayList<>();
        // per ora facciamo il mocking dei dati
        this.languages.add(new Languages(1, "English", "USA"));
        this.languages.add(new Languages(2, "Italian", "Italy"));
        this.languages.add(new Languages(3, "French", "France"));
        this.languages.add(new Languages(4, "Spanish", "Spain"));
        this.languages.add(new Languages(5, "German", "Germany"));
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    // controlla se una lingua è nella lista o meno, restituendo rispettivamente true o false
    private boolean checkLanguagePresence(Languages language) {
        for (Languages currentLanguage : languages) {
            // controlla se nella lista c'è un id uguale a quello della lingua nell'argomento
            if (currentLanguage.getId().equals(language.getId())) {
                // se c'è restituisce true
                return true;
            }
        }
        // se esce dal ciclo senza restituire true vuol dire che la lingua non c'è, quindi restituisce false
        return false;
    }

    // aggiunge una lingua alla lista, restituisce true se riesce, restituisce false se c'è un duplicato
    public boolean addLanguage(Languages language) {
        // controlla che la lingua che sta cercando di aggiungere non sia già nella lista
        if (checkLanguagePresence(language)) {
            // se c'è un duplicato restituisce false
            return false;
        }
        // se non c'è un duplicato aggiunge la lingua alla lista e restituisce true
        this.languages.add(language);
        return true;
    }

    // aggiorna i dati di una lingua della lista, restituisce true se riesce, restituisce false se non trova l'id
    public boolean updateLanguage(Languages language, Integer id) {
        for (Languages currentLanguage : languages) {
            // controlla se nella lista c'è un id uguale a quello nell'argomento
            if (currentLanguage.getId().equals(id)) {
                // se trova l'id aggiorna i dati con quelli della lingua nell'argomento
                currentLanguage.setLanguage(language.getLanguage());
                currentLanguage.setNation(language.getNation());
                // poi restituisce true
                return true;
            }
        }
        // se esce dal ciclo senza restituire true vuol dire che l'id non c'è, quindi restituisce false
        return false;
    }

}
