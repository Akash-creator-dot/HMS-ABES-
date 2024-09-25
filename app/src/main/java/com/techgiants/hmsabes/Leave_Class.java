package com.techgiants.hmsabes;

public class Leave_Class {
    String year,student_mo,CO_Name,address,reason, relation,DateOfLeave,TimeOfLeave,DateOfReturn,TimeOfReturn,name,AdmissionNumber,RoomNumber,dept,BlockName;

    public String getAdmissionNumber() {
        return AdmissionNumber;
    }

    public void setAdmissionNumber(String AdmissionNumber) {
        this.AdmissionNumber = AdmissionNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlockName() {
        return BlockName;
    }

    public void setBlockName(String BlockName) {
        this.BlockName = BlockName;
    }

    public String getCO_Name() {
        return CO_Name;
    }

    public void setCO_Name(String CO_Name) {
        this.CO_Name = CO_Name;
    }

    public String getDateOfLeave() {
        return DateOfLeave;
    }

    public void setDateOfLeave(String DateOfLeave) {
        this.DateOfLeave = DateOfLeave;
    }

    public String getDateOfReturn() {
        return DateOfReturn;
    }

    public void setDateOfReturn(String DateOfReturn) {
        this.DateOfReturn = DateOfReturn;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public String getStudent_mo() {
        return student_mo;
    }

    public void setStudent_mo(String student_mo) {
        this.student_mo = student_mo;
    }

    public String getTimeOfLeave() {
        return TimeOfLeave;
    }

    public void setTimeOfLeave(String TimeOfLeave) {
        this.TimeOfLeave = TimeOfLeave;
    }

    public String getTimeOfReturn() {
        return TimeOfReturn;
    }

    public void setTimeOfReturn(String TimeOfReturn) {
        this.TimeOfReturn = TimeOfReturn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    Leave_Class(String year, String student_mo, String CO_Name, String address, String reason,
                String relation, String DateOfLeave, String TimeOfLeave, String DateOfReturn,
                String TimeOfReturn, String name, String AdmissionNumber, String RoomNumber,
                String dept, String BlockName){
        this.year=year;
        this.student_mo=student_mo;
        this.CO_Name=CO_Name;
        this.address=address;
        this.reason=reason;
        this.relation =relation;
        this.DateOfLeave=DateOfLeave;
        this.TimeOfLeave=TimeOfLeave;
        this.DateOfReturn=DateOfReturn;
        this.TimeOfReturn=TimeOfReturn;
        this.name=name;
        this.AdmissionNumber=AdmissionNumber;
        this.RoomNumber=RoomNumber;
        this.dept=dept;
        this.BlockName=BlockName;
    }
}
