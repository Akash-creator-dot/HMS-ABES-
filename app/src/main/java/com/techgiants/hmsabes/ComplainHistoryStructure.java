package com.techgiants.hmsabes;

public class ComplainHistoryStructure {
    String date, section;

    public ComplainHistoryStructure(String date, String section) {
        this.date = date;
        this.section = section;
    }

    public String getdate() {
        return date;
    }

    public String getsection() {
        return section;
    }
}
