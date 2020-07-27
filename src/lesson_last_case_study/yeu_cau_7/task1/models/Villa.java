package lesson_last_case_study.yeu_cau_7.task1.models;

public class Villa extends Services {
    private String roomStanDard;
    private String comfortDescription;
    private double poolArea;
    private int numberOfFloors;

    public String getRoomStanDard() {
        return roomStanDard;
    }

    public void setRoomStanDard(String roomStanDard) {
        this.roomStanDard = roomStanDard;
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

    public Villa(String nameServices, double areaUse, double rentalCost,
                 int maximumPeople, String typeOfRent, String id,
                 String roomStanDard, String comfortDescription,
                 double poolArea, int numberOfFloors) {
        super(nameServices, areaUse, rentalCost, maximumPeople, typeOfRent, id);
        this.roomStanDard = roomStanDard;
        this.comfortDescription = comfortDescription;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;

    }

    @Override
    public String showInfor() {
        return super.showInfor()+"\t"+
                "room StanDard is" + getRoomStanDard()+"\t"+
                "comfort Description is: " + getComfortDescription()+"\t"+
                "pool Area: "+ getPoolArea()+"\t"+
                "number Of Floors is: "+ getNumberOfFloors()+"\t";

    }
}
