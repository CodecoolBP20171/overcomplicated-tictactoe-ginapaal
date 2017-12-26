package funfact.controller;


import funfact.FunFact;
import funfact.model.FunFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunFactController {

    @Autowired
    private FunFactService funFactService;

    @GetMapping(value="/funfact")
    public FunFactService funfact() {
        return new FunFactService();
    }
}
