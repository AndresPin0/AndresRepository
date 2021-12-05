package model;

public class Rack{
    private Processor processorBrand;
    private double cache;
    private int numProcessor;
    private double ram;
    private int discA;
    private double discC;
    /**
     * Rack constructor
     * @param processorBrand
     * @param cache
     * @param numProcessor
     * @param ram
     * @param discA
     * @param discC
     */
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
    /**
     * getter
     * @return processorBrand
     */
    public Processor getProcessorBrand() {
        return processorBrand;
    }
    /**
     * setter
     * @param processorBrand processorBrand
     */
    public void setProcessorBrand(Processor processorBrand) {
        this.processorBrand = processorBrand;
    }
    /**
     * getter
     * @return cache
     */
    public double getCache() {
        return cache;
    }
    /**
     * setter
     * @param cache cache
     */
    public void setCache(double cache) {
        this.cache = cache;
    }
    /**
     * getter
     * @return numProcessors
     */
    public int getNumProcessor() {
        return numProcessor;
    }
    /**
     * setter
     * @param numProcessor numProcessors
     */
    public void setNumProcessor(int numProcessor) {
        this.numProcessor = numProcessor;
    }
    /**
     * getter
     * @return ram
     */
    public double getRam() {
        return ram;
    }
    /**
     * setter
     * @param ram ram
     */
    public void setRam(double ram) {
        this.ram = ram;
    }
    /**
     * getter
     * @return discAmount
     */
    public int getDiscA() {
        return discA;
    }
    /**
     * setter
     * @param discA discAmount
     */
    public void setDiscA(int discA) {
        this.discA = discA;
    }
    /**
     * getter
     * @return discCapacity
     */
    public double getDiscC() {
        return discC;
    }
    /**
     * setter
     * @param discC discCapacity
     */
    public void setDiscC(double discC) {
        this.discC = discC;
    }
    /**
     * getter
     * @return process
     */
    public double getProcess(){
        return discC+ram;
    }
}