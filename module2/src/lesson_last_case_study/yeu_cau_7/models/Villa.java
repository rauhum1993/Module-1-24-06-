package lesson_last_case_study.yeu_cau_7.models;

public class Villa extends Services {
    private String roomStandard;
    private String comfortDescription;
    private double poolArea;
    private int numberOfFloors;

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getComfortDescription() {
        return comfortDescription;
    }

    public void setComfortDescription(String comfortDescription) {
        this.comfortDescription = comfortDescription;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String id, String nameServices, double areaUse, double rentalCost, int maximumPeople, String typeOfRent, String roomStanDard,
                 String comfortDescription, double poolArea, int numberOfFloors) {
        super(id, nameServices, areaUse, rentalCost, maximumPeople, typeOfRent);
        this.roomStandard = roomStanDard;
        this.comfortDescription = comfortDescription;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor() {
        return super.showInfor()+"\t"+
                "room StanDard is" + getRoomStandard()+"\t"+
                "comfort Description is: " + getComfortDescription()+"\t"+
                "pool Area: "+ getPoolArea()+"\t"+
                "number Of Floors is: "+ getNumberOfFloors()+"\t";

    }
}
