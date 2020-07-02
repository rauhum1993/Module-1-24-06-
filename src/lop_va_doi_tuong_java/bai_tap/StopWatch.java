package lop_va_doi_tuong_java.bai_tap;

import java.util.Date;
import java.util.Scanner;

public class StopWatch {
    private Date startTime;
    private Date endTime;

    public StopWatch() {
    }
    public void start(){
        Date date = new Date();
        this.startTime=date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void stop(){
        Date date = new Date();
        this.endTime= date;
    }
    public long  getElapsedTime(){
        return endTime.getSeconds()-startTime.getSeconds();
    }


    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        StopWatch date=new StopWatch();
        date.start();
        System.out.println(date.getStartTime());
        System.out.println();
        for (int i=0;i<2;i++){

            System.out.println("tung nui noi: ");
            int khanhdeptrai=scanner.nextInt();
            System.out.println("khanh dep trai qua");

        }
        date.stop();
        System.out.println("tung nui noi mat: "+ date.getElapsedTime()+" giay");
    }
}



