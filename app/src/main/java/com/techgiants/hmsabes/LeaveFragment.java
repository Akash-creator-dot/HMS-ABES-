package com.techgiants.hmsabes;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_SHORT;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LeaveFragment extends Fragment {
    private EditText dateOfLeaveTxt, dateOfReturnTxt, timeOfLeaveTxt, year, timeOfReturnTxt, studentMobileNumber, coName, relationship, reason, address;
    private ProgressDialog pd;
    private String name, adm, roomNo, dept, blockName;
    private DatabaseReference databaseReferenceForStudent, databaseReferenceForAdmin;
    private Calendar dateCalendar = Calendar.getInstance();
    private Calendar timeCalendar = Calendar.getInstance();
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leave, container, false);
        databaseReferenceForAdmin = FirebaseDatabase.getInstance().getReference().child("HMS").child("ABES").child("Admin").child("notifications").child("Leaves");
        dateOfLeaveTxt = view.findViewById(R.id.dateOfLeaveTxt);
        year = view.findViewById(R.id.current_year);
        studentMobileNumber = view.findViewById(R.id.student_mobile);
        coName = view.findViewById(R.id.CO_Name);
        address = view.findViewById(R.id.Address);
        reason = view.findViewById(R.id.student_reason);
        pd = new ProgressDialog(getContext());
        pd.setMessage("Uploading...");
        relationship = view.findViewById(R.id.relationship);
        dateOfReturnTxt = view.findViewById(R.id.dateOfReturnTxt);
        timeOfLeaveTxt = view.findViewById(R.id.timeOfLeaveTxt);
        timeOfReturnTxt = view.findViewById(R.id.timeOfReturnTxt);
        Button btn = view.findViewById(R.id.leavefragmentbtn);
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            firestore.collection("users").document(userId).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            fetchUserDetails(documentSnapshot);
                        }
                    })
                    .addOnFailureListener(e -> {
                        Log.d(TAG, "onCreateView:cant fetch user details");
                    });
        }
        // Button click listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    uploadLeaveData();
                } else {
                    Toast.makeText(getContext(), "Please enter all the details", LENGTH_SHORT).show();
                }
            }
        });

        // Setup date and time pickers
        setupDatePicker(dateOfLeaveTxt);
        setupDatePicker(dateOfReturnTxt);
        setupTimePicker(timeOfLeaveTxt);
        setupTimePicker(timeOfReturnTxt);

        return view;
    }

    private void passdetails() {
        Intent intent=new Intent(getContext(),LeaveForm.class);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("dd-MM-yy");
        String date = currentDateFormat.format(calendar.getTime());
        SimpleDateFormat currentTimeFormat = new SimpleDateFormat("hh:mm a");
        String currentTime = currentTimeFormat.format(calendar.getTime());
        intent.putExtra("name",name);
        intent.putExtra("adm",adm);
        intent.putExtra("room",roomNo);
        intent.putExtra("dept",dept);
        intent.putExtra("block",blockName);
        intent.putExtra("dateofapply",date);
        intent.putExtra("timeofapply",currentTime);
        intent.putExtra("Student_no",studentMobileNumber.getText().toString());
        intent.putExtra("coname",coName.getText().toString());
        intent.putExtra("address",address.getText().toString());
        intent.putExtra("reason",reason.getText().toString());
        intent.putExtra("relationship",relationship.getText().toString());
        intent.putExtra("dateofleave",dateOfLeaveTxt.getText().toString());
        intent.putExtra("timeofleave",timeOfLeaveTxt.getText().toString());
        intent.putExtra("dateofreturn",dateOfReturnTxt.getText().toString());
        intent.putExtra("timeofreturn",timeOfReturnTxt.getText().toString());
        intent.putExtra("currentyear",year.getText().toString());
    }

    private void fetchUserDetails(DocumentSnapshot documentSnapshot) {
        name = documentSnapshot.getString("name");
        adm = documentSnapshot.getString("admission_no");
        dept = documentSnapshot.getString("department");
        roomNo=documentSnapshot.getString("room_no");
        blockName=documentSnapshot.getString("block");
    }

    private void setupDatePicker(final EditText editText) {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateCalendar.set(Calendar.YEAR, year);
                        dateCalendar.set(Calendar.MONTH, monthOfYear);
                        dateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateDateLabel(editText, dateCalendar);
                    }
                }, dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }

    private void setupTimePicker(final EditText editText) {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        timeCalendar.set(Calendar.MINUTE, minute);
                        updateTimeLabel(editText, timeCalendar);
                    }
                }, timeCalendar.get(Calendar.HOUR_OF_DAY), timeCalendar.get(Calendar.MINUTE), false);
                timePickerDialog.show();
            }
        });
    }

    // Helper method to update EditText with selected date
    private void updateDateLabel(EditText editText, Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        editText.setText(sdf.format(calendar.getTime()));
    }

    // Helper method to update EditText with selected time
    private void updateTimeLabel(EditText editText, Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:aa", Locale.getDefault());
        editText.setText(sdf.format(calendar.getTime()));
    }

    private boolean validateInputs() {
        return !dateOfLeaveTxt.getText().toString().isEmpty() &&
                !dateOfReturnTxt.getText().toString().isEmpty() &&
                !timeOfLeaveTxt.getText().toString().isEmpty() &&
                !timeOfReturnTxt.getText().toString().isEmpty() &&
                !studentMobileNumber.getText().toString().isEmpty() &&
                !coName.getText().toString().isEmpty() &&
                !relationship.getText().toString().isEmpty();
    }

    private void uploadLeaveData() {
        pd.show();
        final String uniqueKey = databaseReferenceForStudent.push().getKey();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("dd-MM-yy");
        String date = currentDateFormat.format(calendar.getTime());
        SimpleDateFormat currentTimeFormat = new SimpleDateFormat("hh:mm a");
        String currentTime = currentTimeFormat.format(calendar.getTime());

        // Create a leave object with "pending" status
        Leave_Class leave = new Leave_Class(year.getText().toString(),
                studentMobileNumber.getText().toString(),
                coName.getText().toString(),
                address.getText().toString(),
                reason.getText().toString(),
                relationship.getText().toString(),
                dateOfLeaveTxt.getText().toString(),
                timeOfLeaveTxt.getText().toString(),
                dateOfReturnTxt.getText().toString(),
                timeOfReturnTxt.getText().toString(),
                name, adm, roomNo, dept, blockName, uniqueKey, date, currentTime, "pending");
        // Admin database
        databaseReferenceForAdmin.child(adm).setValue(leave);

        // Listener to monitor leave status
        databaseReferenceForStudent.child(uniqueKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Leave_Class leaveData = snapshot.getValue(Leave_Class.class);
                    if (leaveData != null) {
                        String status = leaveData.getStatus();
                        if ("approved".equals(status)) {
                            passdetails();
                            notification();
                            Toast.makeText(getContext(), "Your leave is approved !", LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(),LeaveForm.class));

                        } else if ("denied".equals(status)) {
                            Toast.makeText(getContext(), "Your leave is denied.", LENGTH_SHORT).show();

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
                Toast.makeText(getContext(), "Error fetching leave status", LENGTH_SHORT).show();
            }
        });
    }

    private void notification() {

    }
}
