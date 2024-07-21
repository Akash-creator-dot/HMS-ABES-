package com.techgiants.hmsabes;

public class LeaveHistoryStracture {
    String date,time;
    public LeaveHistoryStracture(String date,String time){
        this.date=date;
        this.time=time;
    }

    public String getdate() {
        return date;
    }
    public String gettime(){
        return time;
    }
}
