package model;

public class Rack{
    private Processor processorBrand;
    private double cache;
    private int numProcessor;
    private double ram;
    private int discA;
    private double discC;

    public Rack(int processorBrand, double cache, int numProcessor, double ram, int discA, double discC) {
        if(processorBrand == 1){
            this.processorBrand = Processor.AMD;
        }else if(processorBrand == 2){
            this.processorBrand = Processor.INTEL;
        }
        this.cache = cache;
        this.numProcessor = numProcessor;
        this.ram = ram;
        this.discA = discA;
        this.discC = discC;
    }

    public Processor getProcessorBrand() {
        return processorBrand;
    }

    public void setProcessorBrand(Processor processorBrand) {
        this.processorBrand = processorBrand;
    }

    public double getCache() {
        return cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    public int getNumProcessor() {
        return numProcessor;
    }

    public void setNumProcessor(int numProcessor) {
        this.numProcessor = numProcessor;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public int getDiscA() {
        return discA;
    }

    public void setDiscA(int discA) {
        this.discA = discA;
    }

    public double getDiscC() {
        return discC;
    }

    public void setDiscC(double discC) {
        this.discC = discC;
    }
    
    public double getProcess(){
        return discC+ram;
    }
}