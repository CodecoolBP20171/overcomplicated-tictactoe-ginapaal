package funfact.controller;


import funfact.model.FunFactService;
import funfact.service.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FunFactController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    @GetMapping(value="/funfact")
    public FunFactService funfact() throws IOException {
        final String URI = "https://api.chucknorris.io/jokes/random";
        return new FunFactService(remoteURLReader.getHTML(URI));
    }
}
