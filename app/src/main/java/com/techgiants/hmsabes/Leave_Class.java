package com.techgiants.hmsabes;

public class Leave_Class {
    private String year, studentMobileNumber, coName, address, reason, relationship;
    private String dateOfLeave, timeOfLeave, dateOfReturn, timeOfReturn;
    private String name, adm, roomNo, dept, blockName, uniqueKey, date, currentTime, status;

    // No-argument constructor (required by Firebase)
    public Leave_Class() {
    }

    // Constructor with all arguments
    public Leave_Class(String year, String studentMobileNumber, String coName, String address,
                       String reason, String relationship, String dateOfLeave, String timeOfLeave,
                       String dateOfReturn, String timeOfReturn, String name, String adm,
                       String roomNo, String dept, String blockName, String uniqueKey,
                       String date, String currentTime, String status) {
        this.year = year;
        this.studentMobileNumber = studentMobileNumber;
        this.coName = coName;
        this.address = address;
        this.reason = reason;
        this.relationship = relationship;
        this.dateOfLeave = dateOfLeave;
        this.timeOfLeave = timeOfLeave;
        this.dateOfReturn = dateOfReturn;
        this.timeOfReturn = timeOfReturn;
        this.name = name;
        this.adm = adm;
        this.roomNo = roomNo;
        this.dept = dept;
        this.blockName = blockName;
        this.uniqueKey = uniqueKey;
        this.date = date;
        this.currentTime = currentTime;
        this.status = status;
    }

    // Getters and setters for all fields
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getStudentMobileNumber() { return studentMobileNumber; }
    public void setStudentMobileNumber(String studentMobileNumber) { this.studentMobileNumber = studentMobileNumber; }

    public String getCoName() { return coName; }
    public void setCoName(String coName) { this.coName = coName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }

    public String getDateOfLeave() { return dateOfLeave; }
    public void setDateOfLeave(String dateOfLeave) { this.dateOfLeave = dateOfLeave; }

    public String getTimeOfLeave() { return timeOfLeave; }
    public void setTimeOfLeave(String timeOfLeave) { this.timeOfLeave = timeOfLeave; }

    public String getDateOfReturn() { return dateOfReturn; }
    public void setDateOfReturn(String dateOfReturn) { this.dateOfReturn = dateOfReturn; }

    public String getTimeOfReturn() { return timeOfReturn; }
    public void setTimeOfReturn(String timeOfReturn) { this.timeOfReturn = timeOfReturn; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAdm() { return adm; }
    public void setAdm(String adm) { this.adm = adm; }

    public String getRoomNo() { return roomNo; }
    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public String getBlockName() { return blockName; }
    public void setBlockName(String blockName) { this.blockName = blockName; }

    public String getUniqueKey() { return uniqueKey; }
    public void setUniqueKey(String uniqueKey) { this.uniqueKey = uniqueKey; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getCurrentTime() { return currentTime; }
    public void setCurrentTime(String currentTime) { this.currentTime = currentTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
