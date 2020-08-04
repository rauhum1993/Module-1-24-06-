package lesson_last_case_study.yeu_cau_7.models;

public class House extends Services {
    private String roomStanDard;
    private String comfortDescription;
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public House(String id, String nameServices, double areaUse, double rentalCost, int maximumPeople, String typeOfRent,
                 String roomStanDard, String comfortDescription, int numberOfFloors) {
        super(id, nameServices, areaUse, rentalCost, maximumPeople, typeOfRent);
        this.roomStanDard = roomStanDard;
        this.comfortDescription = comfortDescription;
        this.numberOfFloors = numberOfFloors;
    }


    @Override
    public String showInfor() {

        return super.showInfor()+"\t"
                + " Number Of Floors is: " + getNumberOfFloors()+"\t"
                + "room StanDard  is: " + getRoomStanDard()+"\t"
                + " comfort Description is: " + getComfortDescription()+"\t";
    }
}
