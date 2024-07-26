package com.techgiants.hmsabes;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class LeaveFragment extends Fragment {
    EditText dateOfLeaveTxt, dateOfReturnTxt, timeOfLeaveTxt, timeOfReturnTxt;
    final Calendar dateCalendar = Calendar.getInstance();
    final Calendar timeCalendar = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leave, container, false);
        dateOfLeaveTxt = view.findViewById(R.id.dateOfLeaveTxt);
        dateOfReturnTxt = view.findViewById(R.id.dateOfReturnTxt);
        timeOfLeaveTxt = view.findViewById(R.id.timeOfLeaveTxt);
        timeOfReturnTxt = view.findViewById(R.id.timeOfReturnTxt);
        Button btn = view.findViewById(R.id.leavefragmentbtn);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.getString("name");
            String adm = bundle.getString("adm");
            String roomno = bundle.getString("roomno");
            String dept = bundle.getString("dept");
            String blockname = bundle.getString("blockname");
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OtpSending.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(getContext(), OtpSending.class);
             startActivity(intent);
            }
        });
        // Set listeners for date and time pickers
        setupDatePicker(dateOfLeaveTxt);
        setupDatePicker(dateOfReturnTxt);
        setupTimePicker(timeOfLeaveTxt);
        setupTimePicker(timeOfReturnTxt);
        TextView txt = view.findViewById(R.id.complainsheadingtxt);
        return view;
    }

    // Helper method to set up Date Picker dialog
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

    // Helper method to set up Time Picker dialog
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
}
