package com.techgiants.hmsabes;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeaveForm extends AppCompatActivity {
    private TextView name, admissionno, course, branch, year, block, roomno, dateofleave, timeofleave, datetoreturn, timeofreturn, reason, coname, relationship, parentsph, studentph, address;
    String nam, adm, cour, br, yea, blo, room, datele, timele, retdat, rettim, rea, conam, rela, pareph, stuph, add;
    Button btnpdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leave_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize TextViews
        name = findViewById(R.id.formname);
        admissionno = findViewById(R.id.formadmno);
        course = findViewById(R.id.formcourse);
        branch = findViewById(R.id.formbranch);
        year = findViewById(R.id.formyear);
        block = findViewById(R.id.formblock);
        roomno = findViewById(R.id.formroomno);
        dateofleave = findViewById(R.id.formdateofleave);
        timeofleave = findViewById(R.id.formtimeofleave);
        datetoreturn = findViewById(R.id.formreturndate);
        timeofreturn = findViewById(R.id.formreturntime);
        reason = findViewById(R.id.formreason);
        coname = findViewById(R.id.formconame);
        relationship = findViewById(R.id.formrelationship);
        parentsph = findViewById(R.id.formparentsph);
        studentph = findViewById(R.id.formstudentph);
        address = findViewById(R.id.formaddress);

        // Get data from Intent
        Intent intent = getIntent();
        nam = intent.getStringExtra("name");
        adm = intent.getStringExtra("admno");
        room = intent.getStringExtra("roomno");
        br = intent.getStringExtra("dept");
        blo = intent.getStringExtra("blockname");
        datele = intent.getStringExtra("dateofleave");
        timele = intent.getStringExtra("timeofleave");
        retdat = intent.getStringExtra("dateofreturn");
        rettim = intent.getStringExtra("timeofreturn");
        conam = intent.getStringExtra("coname");
        rela = intent.getStringExtra("relationship");
        rea = intent.getStringExtra("reason");
        yea = intent.getStringExtra("currentyear");
        add = intent.getStringExtra("address");
        stuph = intent.getStringExtra("studentmo");

        // Set text to views
        name.setText(nam);
        admissionno.setText(adm);
        roomno.setText(room);
        branch.setText(br);
        block.setText(blo);
        dateofleave.setText(datele);
        timeofleave.setText(timele);
        datetoreturn.setText(retdat);
        timeofreturn.setText(rettim);
        coname.setText(conam);
        relationship.setText(rela);
        reason.setText(rea);
        year.setText(yea);
        address.setText(add);
        studentph.setText(stuph);
        course.setText(cour);

        // Button to create PDF
        btnpdf = findViewById(R.id.leaveformpdf);
        btnpdf.setOnClickListener(v -> createPDF());
    }

    // Method to create PDF
    private void createPDF() {
        // Create a new PDF document
        PdfDocument pdfDocument = new PdfDocument();
        Paint paint = new Paint();

        // Start a page
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(595, 842, 1).create(); // A4 size page
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        // Add content to the PDF
        paint.setTextSize(20);
        canvas.drawText("Leave Form", 250, 40, paint);
        paint.setTextSize(14);
        canvas.drawText("Name: " + nam, 50, 100, paint);
        canvas.drawText("Admission No: " + adm, 50, 130, paint);
        canvas.drawText("Course: " + cour, 50, 160, paint);
        canvas.drawText("Branch: " + br, 50, 190, paint);
        canvas.drawText("Year: " + yea, 50, 220, paint);
        canvas.drawText("Block: " + blo, 50, 250, paint);
        canvas.drawText("Room No: " + room, 50, 280, paint);
        paint.setTextSize(16);
        canvas.drawText("Request you to kindly allow me to leave hostel on date", 50, 310, paint);
        paint.setTextSize(14);
        canvas.drawText("Date of Leave: " + datele, 50, 340, paint);
        canvas.drawText("Time of Leave: " + timele, 50, 370, paint);
        paint.setTextSize(16);
        canvas.drawText("At my own risk and responsibility", 50, 400, paint);
        paint.setTextSize(14);
        canvas.drawText("Reason: " + rea, 50, 430, paint);
        paint.setTextSize(16);
        canvas.drawText("I assure that I Shall report back to hostel on date", 50, 460, paint);
        paint.setTextSize(14);
        canvas.drawText("Return Date: " + retdat, 50, 490, paint);
        canvas.drawText("Return Time: " + rettim, 50, 520, paint);
        paint.setTextSize(16);
        canvas.drawText("My leave address is as follows", 50, 550, paint);
        paint.setTextSize(14);
        canvas.drawText("CO Name: " + conam, 50, 580, paint);
        canvas.drawText("Relationship: " + rela, 50, 610, paint);
        canvas.drawText("Address: " + add, 50, 640, paint);
        canvas.drawText("Student Phone: " + stuph, 50, 670, paint);

        // Finish the page
        pdfDocument.finishPage(page);

        // Save the document to external storage
        File pdfDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "LeaveForms");
        if (!pdfDir.exists()) {
            pdfDir.mkdirs();
        }
        File pdfFile = new File(pdfDir, "LeaveForm_" + nam + ".pdf");

        try {
            pdfDocument.writeTo(new FileOutputStream(pdfFile));
            Toast.makeText(this, "PDF saved in Documents/LeaveForms", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to create PDF", Toast.LENGTH_SHORT).show();
        }

        // Close the document
        pdfDocument.close();
    }
}
