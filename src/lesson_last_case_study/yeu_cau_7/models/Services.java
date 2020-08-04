package lesson_last_case_study.yeu_cau_7.models;

public abstract class Services {
    private String nameServices;
    private double areaUse;
    private double rentalCost;
    private int maximumPeople;
    private String typeOfRent;
    private String id;

    public Services() {
    }

    public Services(String id,String nameServices, double areaUse, double rentalCost, int maximumPeople, String typeOfRent ) {
        this.nameServices = nameServices;
        this.areaUse = areaUse;
        this.rentalCost = rentalCost;
        this.maximumPeople = maximumPeople;
        this.typeOfRent = typeOfRent;
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String showInfor() {
        return "ID is: " + getId() +"\t"+
                "nameServices is: " + getNameServices() + "\t"+
                "areaUse is: " + getAreaUse() + "\t"+
                "rentalCost is : " + getRentalCost() +"\t"+
                "maximumPeople is: " + getMaximumPeople() +"\t"+
                "typeOfRent is: " + getTypeOfRent()+"\t";



    }
}
