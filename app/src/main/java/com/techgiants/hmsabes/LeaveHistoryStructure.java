package com.techgiants.hmsabes;

public class LeaveHistoryStructure {
    String date,time;
    public LeaveHistoryStructure(String date, String time){
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
