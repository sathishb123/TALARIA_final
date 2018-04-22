package egrb301juliet.talaria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    EditText editPatientName;
    Button buttonAdd;
    Spinner spinnerRoomNumber;

    DatabaseReference databasePatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        databasePatients =  FirebaseDatabase.getInstance().getReference("patients");

        editPatientName = (EditText) findViewById(R.id.editPatientName);
        buttonAdd =  (Button) findViewById(R.id.buttonAddPatient);
        spinnerRoomNumber = (Spinner) findViewById(R.id.spinnerRoomNumber);

        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                addPatient();
            }
        });
    }

    private void addPatient(){
        String name = editPatientName.getText().toString().trim();
        String roomNumber = spinnerRoomNumber.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){

            String id = databasePatients.push().getKey();
                Patient patient = new Patient(id, name, roomNumber);

                databasePatients.child(id).setValue(patient);

            Toast.makeText(this, "Patient added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Please enter a patient name.", Toast.LENGTH_LONG).show();
        }
    }

}

