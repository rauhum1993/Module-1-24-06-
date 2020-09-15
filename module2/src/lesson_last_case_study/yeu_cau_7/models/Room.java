package lesson_last_case_study.yeu_cau_7.models;

public class Room extends Services {
    private String freeServiceIncluded;

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }


    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String id, String nameServices, double areaUse, double rentalCost, int maximumPeople, String typeOfRent, String freeServiceIncluded) {
        super(id, nameServices, areaUse, rentalCost, maximumPeople, typeOfRent);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String showInfor() {
        return super.showInfor()+"\t"+
                "free Service Included is"+ getFreeServiceIncluded();
    }
}
