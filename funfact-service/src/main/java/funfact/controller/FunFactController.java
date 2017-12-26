package funfact.controller;


import funfact.FunFact;
import funfact.model.FunFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class FunFactController {

    @Autowired
    private FunFactService funFactService;

    @GetMapping(value="/funfact")
    public FunFactService funfact() throws IOException {
        List<String> quoteList = new ArrayList<>();
        quoteList.add("ez");
        quoteList.add("az");
        quoteList.add("amaz");
        quoteList.add("emez");
        Random random = new Random();
        int index = random.nextInt(quoteList.size());
        String myFunFact = quoteList.get(index);
        return new FunFactService(myFunFact);
    }
}
