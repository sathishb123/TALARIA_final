package egrb301juliet.talaria;

/**
 * Created by Bhargav on 4/22/2018.
 */

public class Patient {

    String patientMRN;
    String patientName;
    String patientRoomNumber;

    public Patient(){

    }

    public Patient(String patientMRN, String patientName, String patientRoomNumber) {
        this.patientMRN = patientMRN;
        this.patientName = patientName;
        this.patientRoomNumber = patientRoomNumber;
    }

    public String getPatientMRN() {
        return patientMRN;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientRoomNumber() {
        return patientRoomNumber;
    }
}
