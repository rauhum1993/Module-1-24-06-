package lesson_last_case_study.yeu_cau_7.models;

public class FreeServicesIncluded {
    private String nameServicesIncluded;
    private int unit;
    private double servicesPrices;

    public String getNameServicesIncluded() {
        return nameServicesIncluded;
    }

    public void setNameServicesIncluded(String nameServicesIncluded) {
        this.nameServicesIncluded = nameServicesIncluded;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getServicesPrices() {
        return servicesPrices;
    }

    public void setServicesPrices(double servicesPrices) {
        this.servicesPrices = servicesPrices;
    }

    public FreeServicesIncluded(String nameServicesIncluded, int unit, double servicesPrices) {
        this.nameServicesIncluded = nameServicesIncluded;
        this.unit = unit;
        this.servicesPrices = servicesPrices;
    }
}
