package com.techgiants.hmsabes;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class LeaveFragment extends Fragment {

    String[] department = {
            "Computer Science and Engineering",
            "CSE (Artificial Intelligence & Machine Learning)",
            "CSE (Data Science)",
            "Electrical and Computer Engineering",
            "Electronics and Communication Engineering",
            "Mechanical Engineering",
            "Computer Science",
            "Information Technology",
            "Computer Engineering",
            "Electrical and Electronics Engineering"
    };

    String[] boysBlockName = {"VKB", "CKB", "DNB", "ABB"};

    AutoCompleteTextView departmentTxt, blockNameTxt;
    EditText dateOfLeaveTxt, dateOfReturnTxt, timeOfLeaveTxt, timeOfReturnTxt;

    final Calendar myCalendar = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leave, container, false);

        // Set title if needed
        // getActivity().setTitle("Leave Page");

        // Initialize department and block name AutoCompleteTextViews
        departmentTxt = view.findViewById(R.id.auto_complete_txt);
        blockNameTxt = view.findViewById(R.id.blockName_txt);

        // Set adapters for AutoCompleteTextViews
        ArrayAdapter<String> departmentAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, department);
        departmentTxt.setAdapter(departmentAdapter);
        ArrayAdapter<String> blockNameAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, boysBlockName);
        blockNameTxt.setAdapter(blockNameAdapter);

        // Initialize date and time EditText fields
        dateOfLeaveTxt = view.findViewById(R.id.dateOfLeaveTxt);
        dateOfReturnTxt = view.findViewById(R.id.dateOfReturnTxt);
        timeOfLeaveTxt = view.findViewById(R.id.timeOfLeaveTxt);
        timeOfReturnTxt = view.findViewById(R.id.timeOfReturnTxt);

        // Set listeners for date and time pickers
        setupDateTimePicker(dateOfLeaveTxt);
        setupDateTimePicker(dateOfReturnTxt);
        setupTimePicker(timeOfLeaveTxt);
        setupTimePicker(timeOfReturnTxt);

        return view;
    }

    // Helper method to set up Date Picker dialog
    private void setupDateTimePicker(final EditText editText) {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext());
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel(editText, myCalendar);
                    }
                });
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
                        myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        myCalendar.set(Calendar.MINUTE, minute);
                        updateLabel(editText, myCalendar);
                    }
                }, myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE), false);
                timePickerDialog.show();
            }
        });
    }

    // Helper method to update EditText with selected date/time
    private void updateLabel(EditText editText, Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        editText.setText(sdf.format(calendar.getTime()));
    }
}