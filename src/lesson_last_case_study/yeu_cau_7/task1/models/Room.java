package lesson_last_case_study.yeu_cau_7.task1.models;

public class Room extends Services {
    private String freeServiceIncluded;

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String nameServices, double areaUse, double rentalCost, int maximumPeople, String typeOfRent,String id,  String freeServiceIncluded) {
        super(nameServices, areaUse, rentalCost, maximumPeople, typeOfRent, id);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String showInfor() {
        return super.showInfor()+"\t"+
                "free Service Included is"+ getFreeServiceIncluded();
    }
}
