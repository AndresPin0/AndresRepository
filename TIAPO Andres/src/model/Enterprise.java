package model;

public class Enterprise{
    private String name;
    private String nit;
    /**
     * Enterprise contructor
     * @param name
     * @param nit
     */
    public Enterprise(String name, String nit) {
        this.name = name;
        this.nit = nit;
    }   
    /**
     * getter
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * setter
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter
     * @return nit
     */
    public String getNit() {
        return nit;
    }
    /**
     * setter
     * @param nit nit
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
}