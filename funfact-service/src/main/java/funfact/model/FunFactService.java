package funfact.model;

import org.springframework.stereotype.Component;

@Component
public class FunFactService {

    private String funfact;

    public FunFactService() {
        this.funfact = "This is a fun fact";
    }

    public String getFunfact() {
        return funfact;
    }
}
