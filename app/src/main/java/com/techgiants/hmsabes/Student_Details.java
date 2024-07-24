package com.techgiants.hmsabes;

import android.os.Parcel;
import android.os.Parcelable;

public class Student_Details implements Parcelable {
    private String name;
    private String roomNo;
    private String blockName;
    private String department;
    private String admissionNo;

    public Student_Details(String name, String roomNo, String blockName, String department, String admissionNo) {
        this.name = name;
        this.roomNo = roomNo;
        this.blockName = blockName;
        this.department = department;
        this.admissionNo = admissionNo;
    }

    protected Student_Details(Parcel in) {
        name = in.readString();
        roomNo = in.readString();
        blockName = in.readString();
        department = in.readString();
        admissionNo = in.readString();
    }

    public static final Creator<Student_Details> CREATOR = new Creator<Student_Details>() {
        @Override
        public Student_Details createFromParcel(Parcel in) {
            return new Student_Details(in);
        }

        @Override
        public Student_Details[] newArray(int size) {
            return new Student_Details[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(roomNo);
        dest.writeString(blockName);
        dest.writeString(department);
        dest.writeString(admissionNo);
    }
}
