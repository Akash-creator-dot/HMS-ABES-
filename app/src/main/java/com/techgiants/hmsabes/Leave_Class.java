package com.techgiants.hmsabes;

public class Leave_Class {
    // Class fields
    private String year;
    private String student_mo;
    private String CO_Name;
    private String address;
    private String reason;
    private String relation;
    private String DateOfLeave;
    private String TimeOfLeave;
    private String DateOfReturn;
    private String TimeOfReturn;
    private String name;
    private String AdmissionNumber;
    private String RoomNumber;
    private String dept;
    private String BlockName;
    private String uniqueKwy;
    private String currentDate;
    private String status;
    private String currentTime;

    // No-argument constructor
    public Leave_Class() {
        // Default constructor required for calls to DataSnapshot.getValue(Leave_Class.class)
    }

    // Parameterized constructor
    public Leave_Class(String year, String student_mo, String CO_Name, String address, String reason,
                       String relation, String DateOfLeave, String TimeOfLeave, String DateOfReturn,
                       String TimeOfReturn, String name, String AdmissionNumber, String RoomNumber,
                       String dept, String BlockName, String uniqueKwy, String currentDate,
                       String currentTime, String status) {
        this.year = year;
        this.student_mo = student_mo;
        this.CO_Name = CO_Name;
        this.address = address;
        this.reason = reason;
        this.relation = relation;
        this.DateOfLeave = DateOfLeave;
        this.TimeOfLeave = TimeOfLeave;
        this.DateOfReturn = DateOfReturn;
        this.TimeOfReturn = TimeOfReturn;
        this.name = name;
        this.AdmissionNumber = AdmissionNumber;
        this.RoomNumber = RoomNumber;
        this.dept = dept;
        this.BlockName = BlockName;
        this.uniqueKwy = uniqueKwy;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.status = status;
    }
    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getUniqueKwy() {
        return uniqueKwy;
    }

    public void setUniqueKwy(String uniqueKwy) {
        this.uniqueKwy = uniqueKwy;
    }

    public String getAdmissionNumber() {
        return AdmissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.AdmissionNumber = admissionNumber;
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

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
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

    public void setDateOfLeave(String dateOfLeave) {
        this.DateOfLeave = dateOfLeave;
    }

    public String getDateOfReturn() {
        return DateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.DateOfReturn = dateOfReturn;
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

    public void setRoomNumber(String roomNumber) {
        this.RoomNumber = roomNumber;
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

    public void setTimeOfLeave(String timeOfLeave) {
        this.TimeOfLeave = timeOfLeave;
    }

    public String getTimeOfReturn() {
        return TimeOfReturn;
    }

    public void setTimeOfReturn(String timeOfReturn) {
        this.TimeOfReturn = timeOfReturn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
