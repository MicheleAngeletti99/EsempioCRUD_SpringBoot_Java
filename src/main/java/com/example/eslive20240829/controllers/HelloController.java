package com.example.eslive20240829.controllers;

import com.example.eslive20240829.entities.Languages;
import com.example.eslive20240829.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// i controller richiamano i servizi richiesti dagli utenti
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired // dice a Spring Boot che mi deve iniettare un'istanza di questo service (Dependency Injection)
    private HelloService helloService;

    // restituisce la lista di lingue
    @GetMapping("/languages")
    public List<Languages> showLanguages() {
        return helloService.getLanguages();
    }

    // aggiunge alla lista di lingue un elemento e restituisce la lista aggiornata
    @PostMapping("/greeting")
    public ResponseEntity<List<Languages>> createMessage(@RequestBody Languages language) {
        // il metodo del servizio richiamato restituisce un booleano ad indicare se l'operazione è andata a buon fine o no
        boolean checkDuplicate = helloService.addLanguage(language);
        if (checkDuplicate) {
            // se è andata a buon fine il codice di risposta è 200 ok, poi tra parentesi c'è il body della risposta
            return ResponseEntity.ok(helloService.getLanguages());
        } else {
            // se non è andata a buon fine il codice di risposta è 400 bad request,
            // poi il metodo build() è una chiamata statica che crea un "body standard"
            return ResponseEntity.badRequest().build();
        }
    }

    // aggiorna un elemento della lista di lingue e restituisce la lista aggiornata, secondo i seguenti step:
    // step 1 cercare l'oggetto da aggiornare
    // step 2 una volta trovato prendiamo l'oggetto in entrata e sostituiamo i dati con l'oggetto già memorizzato (non l'id)
    // step 3 restituire una response entity positiva o negativa
    @PutMapping("/tryThis")
    public ResponseEntity<List<Languages>> putExample(@RequestBody Languages language, @RequestParam Integer id) {
        // il metodo del servizio richiamato restituisce un booleano ad indicare se l'operazione è andata a buon fine o no
        boolean checkUpdate = helloService.updateLanguage(language, id);
        if (checkUpdate) {
            // se è andata a buon fine il codice di risposta è 200 ok, poi tra parentesi c'è il body della risposta
            return ResponseEntity.ok(helloService.getLanguages());
        } else {
            // se non è andata a buon fine il codice di risposta è 400 bad request,
            // poi il metodo build() è una chiamata statica che crea un "body standard"
            return ResponseEntity.badRequest().build(); // qui qualcosa non va, dobbiamo debuggare
        }
    }
}
