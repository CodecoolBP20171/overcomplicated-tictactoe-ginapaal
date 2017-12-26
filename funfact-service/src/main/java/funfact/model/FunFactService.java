package funfact.model;

import funfact.FunFact;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FunFactService {

    private String value;
    private String funfact;

    public FunFactService() {
    }

    public FunFactService(String funfact) {
        this.funfact = funfact;
    }

    public String getFunfact() {
        return funfact;
    }

    public void setFunfact(String funfact) {
        this.funfact = funfact;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
