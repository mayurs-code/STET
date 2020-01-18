package com.sih.stet.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sih.stet.R;
import com.sih.stet.model.ApplicationModel;

import java.util.Objects;

public class FillFormActivity extends AppCompatActivity {

    TextInputEditText firstNameFormField;
    TextInputEditText lastNameFormField;
    TextInputEditText fathersNameFormField;
    TextInputEditText mothersNameFormField;
    DatePicker datePickerForm;
    RadioGroup genderRadio;
    RadioGroup casteRadio;
    RadioGroup teacherCategoryRadio;
    RadioGroup imparedCategoryRadio;
    RadioGroup appearedBeforeRadio;
    TextInputEditText addressFormField;
    TextInputEditText cityFormField;
    TextInputEditText stateFormField;
    TextInputEditText pincodeFormField;
    TextInputEditText mobileFormField;
    TextInputEditText aadharFormField;
    Spinner paperLanguageSpinnerForm;
    Spinner paperTypeSpinnerForm;
    MaterialButton saveFormButton;
    MaterialButton nextFormButton;
    ApplicationModel applicationModel;
    String applicationNumber;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form);
        members();
        methods();

    }


    private void members() {
        applicationModel=new ApplicationModel();
        firstNameFormField = findViewById(R.id.firstNameFormField);
        lastNameFormField = findViewById(R.id.lastNameFormField);
        fathersNameFormField = findViewById(R.id.fathersNameFormField);
        mothersNameFormField = findViewById(R.id.mothersNameFormField);
        datePickerForm = findViewById(R.id.datePickerForm);
        genderRadio = findViewById(R.id.genderRadio);
        casteRadio = findViewById(R.id.casteRadio);
        teacherCategoryRadio = findViewById(R.id.teacherCategoryRadio);
        imparedCategoryRadio = findViewById(R.id.imparedCategoryRadio);
        appearedBeforeRadio = findViewById(R.id.appearedBeforeRadio);
        addressFormField = findViewById(R.id.addressFormField);
        addressFormField = findViewById(R.id.addressFormField);
        cityFormField = findViewById(R.id.cityFormField);
        stateFormField = findViewById(R.id.stateFormField);
        pincodeFormField = findViewById(R.id.pincodeFormField);
        mobileFormField = findViewById(R.id.mobileFormField);
        aadharFormField = findViewById(R.id.aadharFormField);
        paperLanguageSpinnerForm = findViewById(R.id.paperLanguageSpinnerForm);
        paperTypeSpinnerForm = findViewById(R.id.paperTypeSpinnerForm);
        saveFormButton = findViewById(R.id.saveFormButton);
        nextFormButton = findViewById(R.id.nextFormButton);
    }

    private void methods() {
        getApplicationModel();
    }

    private void enableNextButton() {

        if (applicationModel.checkFormalties()) {
            nextFormButton.setText("NEXT");
            nextFormButton.setEnabled(true);

        }
        else {

            nextFormButton.setText("Incomplete Form");
            nextFormButton.setEnabled(true);
        }
    }

    private void getApplicationModel() {
        db.collection("user").whereEqualTo("application_no", applicationNumber).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (Objects.requireNonNull(task.getResult()).size() >= 1) {
                    applicationModel = task.getResult().getDocuments().get(0).toObject(ApplicationModel.class);
                    fillData(applicationModel);
                    enableNextButton();
                }

            }
        });
    }

    private void fillData(ApplicationModel applicationModel) {
        firstNameFormField.setText(applicationModel.getFirst_name());
        lastNameFormField.setText(applicationModel.getLast_name());
        fathersNameFormField.setText(applicationModel.getFather_name());
        mothersNameFormField.setText(applicationModel.getMother_name());
        String[] date = applicationModel.getDob().split("-");
        datePickerForm.updateDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        if (applicationModel.getGender().equals("Male")) {
            genderRadio.check(R.id.maleRadio);
        } else {
            genderRadio.check(R.id.femaleRadio);
        }
        if (applicationModel.getImpared().equals("YES")) {
            genderRadio.check(R.id.imparedYesRadio);
        } else {
            genderRadio.check(R.id.imparedNoRadio);
        }
        if (applicationModel.getAppeared().equals("YES")) {
            genderRadio.check(R.id.appearedYesRadio);
        } else {
            genderRadio.check(R.id.appearedNoRadio);
        }

        if (applicationModel.getCaste().equals("General")) {
            genderRadio.check(R.id.generalRadio);
        } else if (applicationModel.getCaste().equals("SC")) {
            genderRadio.check(R.id.scRadio);
        } else if (applicationModel.getCaste().equals("ST")) {
            genderRadio.check(R.id.stRadio);
        } else if (applicationModel.getCaste().equals("OBC")) {
            genderRadio.check(R.id.obcRadio);
        }

        if (applicationModel.getTeacherCat().equals("tCat1")) {
            genderRadio.check(R.id.cat1Radio);
        } else if (applicationModel.getCaste().equals("tCat2")) {
            genderRadio.check(R.id.cat2Radio);
        } else if (applicationModel.getCaste().equals("tCat3")) {
            genderRadio.check(R.id.cat3Radio);
        }
        cityFormField.setText(applicationModel.getCity());
        stateFormField.setText(applicationModel.getState());
        pincodeFormField.setText(applicationModel.getPin());
        mobileFormField.setText(applicationModel.getMobile_number());
        aadharFormField.setText(applicationModel.getAadhar_number());

        if (applicationModel.getPaperLanguage().equals("Hindi")) {
            paperLanguageSpinnerForm.setSelection(0);
        } else if (applicationModel.getPaperLanguage().equals("Nepali")) {
            paperLanguageSpinnerForm.setSelection(1);
        } else if (applicationModel.getPaperLanguage().equals("Bhutia")) {
            paperLanguageSpinnerForm.setSelection(2);
        } else if (applicationModel.getPaperLanguage().equals("Lepcha")) {
            paperLanguageSpinnerForm.setSelection(3);
        } else if (applicationModel.getPaperLanguage().equals("Limboo")) {
            paperLanguageSpinnerForm.setSelection(4);

        }

        if (applicationModel.getPaper_type().equals("Paper-1(Primary)")) {
            paperTypeSpinnerForm.setSelection(0);
        } else if (applicationModel.getPaper_type().equals("Paper-2(Secondary)")) {
            paperTypeSpinnerForm.setSelection(1);

        }
    }


    public void saveDetails(View view) {
        Log.d("PIZZA", "saveDetails: PIZZA ");
        Log.d("PIZZA", "saveDetails: "+applicationModel.toString());

        getFilledData();
        enableNextButton();

        System.out.println(applicationModel.toString());
        Log.d("PIZZA", "saveDetails: "+applicationModel.toString());

    }

    private void getFilledData() {
        applicationModel.setFirst_name(firstNameFormField.getText().toString());
        applicationModel.setLast_name(lastNameFormField.getText().toString());
        applicationModel.setFather_name(fathersNameFormField.getText().toString());
        applicationModel.setMother_name(mothersNameFormField.getText().toString());
        applicationModel.setAddress(addressFormField.getText().toString());
        applicationModel.setCity(cityFormField.getText().toString());
        applicationModel.setState(stateFormField.getText().toString());
        applicationModel.setPin(pincodeFormField.getText().toString());
        applicationModel.setMobile_number(mobileFormField.getText().toString());
        applicationModel.setAadhar_number(aadharFormField.getText().toString());
        applicationModel.setDob(datePickerForm.getYear() + "-" + datePickerForm.getMonth() + "-" + datePickerForm.getDayOfMonth());
        if (genderRadio.getCheckedRadioButtonId() == R.id.maleRadio) {
            applicationModel.setGender("Male");
        } else {
            applicationModel.setGender("Female");
        }
        if (casteRadio.getCheckedRadioButtonId() == R.id.generalRadio) {
            applicationModel.setCaste("General");
        } else if (casteRadio.getCheckedRadioButtonId() == R.id.scRadio) {
            applicationModel.setCaste("SC");
        } else if (casteRadio.getCheckedRadioButtonId() == R.id.stRadio) {
            applicationModel.setCaste("ST");
        } else if (casteRadio.getCheckedRadioButtonId() == R.id.obcRadio) {
            applicationModel.setCaste("OBC");
        }
        applicationModel.setPaperLanguage(paperLanguageSpinnerForm.getSelectedItem().toString());
        applicationModel.setPaper_type(paperTypeSpinnerForm.getSelectedItem().toString());
        if (teacherCategoryRadio.getCheckedRadioButtonId() == R.id.cat1Radio) {
            applicationModel.setTeacherCat("tCat1");
        } else if (teacherCategoryRadio.getCheckedRadioButtonId() == R.id.cat2Radio) {
            applicationModel.setTeacherCat("tCat2");
        } else if (teacherCategoryRadio.getCheckedRadioButtonId() == R.id.cat3Radio) {
            applicationModel.setTeacherCat("tCat3");
        }

        if(imparedCategoryRadio.getCheckedRadioButtonId()==R.id.imparedYesRadio){
            applicationModel.setImpared("YES");
        }else {
            applicationModel.setImpared("NO");

        }
        if(appearedBeforeRadio.getCheckedRadioButtonId()==R.id.appearedYesRadio){
            applicationModel.setAppeared("YES");
        }else {
            applicationModel.setAppeared("NO");

        }



    }
}
