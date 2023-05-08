public class Notebook {
    private String name;
    private String operatingSystem;
    private String ram;
    private String hardDisk;
    private String colour;
    
    public Notebook(String name, String operatingSystem, String ram, String hardDisk, String colour) {
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.colour = colour;
    }
    public String getName() {
        return name;
    }
    public String getOperatingSystem() {
        return operatingSystem;
    }
    public String getRam() {
        return ram;
    }
    public String getHardDisk() {
        return hardDisk;
    }
    public String getColour() {
        return colour;
    }
    
    @Override
    public String toString() {
        return "Notebook [name= " + name + ", operatingSystem= " + operatingSystem + 
        ", ram= " + ram + ", hardDisk= " + hardDisk +  ", colour= " + colour + "]";
    } 
}
