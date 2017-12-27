package funfact.model;

public class FunFactService {

    private String value;
    private String funfact;

    public FunFactService() {
    }

    public FunFactService(String funfact) {
        this.funfact = funfact;
        System.out.println(funfact);
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
