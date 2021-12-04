package model;

public class Enterprise{
    private String name;
    private String nit;
    
    public Enterprise(String name, String nit) {
        this.name = name;
        this.nit = nit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
}