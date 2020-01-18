package com.sih.stet.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.chip.Chip;
import com.google.firebase.firestore.DocumentSnapshot;
import com.sih.stet.constants.values;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sih.stet.R;
import com.sih.stet.model.ActionModel;

public class MainActivity extends AppCompatActivity {


    boolean loggedIn=false;
    LinearLayout loginLayout;
    Chip admitCardChip;
    Chip applicationFormChip;
    Chip resultChip;
    SharedPreferences preferences;
    String applicationNumber;

    FirebaseFirestore db=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        members();
        methods();
    }

    private void members() {
        preferences = getPreferences(Context.MODE_PRIVATE);

        loginLayout=findViewById(R.id.loginLayout);
        admitCardChip=findViewById(R.id.admitCardChip);
        applicationFormChip=findViewById(R.id.applicationFormChip);
        resultChip=findViewById(R.id.resultChip);
    }

    private void methods() {
        statusChecker();
        loginChecker();
    }

    private void statusChecker() {
        Toast.makeText(this, "Welcome"+preferences.getString("applicationNumber","---"), Toast.LENGTH_SHORT).show();
        if (!preferences.getString("applicationNumber","---").equals("---")){
            applicationNumber=preferences.getString("applicationNumber","---");
            loggedIn=true;
            loginLayout.setVisibility(View.GONE);

        }
        db.document(values.viewResultStatus()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                ActionModel Model=task.getResult().toObject(ActionModel.class);
                if (Model.getStatus().equals("running")){
                    resultChip.setChipBackgroundColorResource(R.color.themePrimary);
                    resultChip.setEnabled(true);
                }
                else {
                    resultChip.setText(Model.getMessage()+"-"+Model.getStatus());
                }
            }
        });
        db.document(values.downloadAdmitCardStatus()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                ActionModel Model=task.getResult().toObject(ActionModel.class);
                if (Model.getStatus().equals("running")){
                    admitCardChip.setChipBackgroundColorResource(R.color.themePrimary);
                    admitCardChip.setEnabled(true);
                }
                else {
                    admitCardChip.setText(Model.getMessage()+"-"+Model.getStatus());
                }
            }
        });
        db.document(values.fillApplicationForStatus()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                ActionModel Model=task.getResult().toObject(ActionModel.class);
                if (Model.getStatus().equals("running")){
                    applicationFormChip.setChipBackgroundColorResource(R.color.themePrimary);
                    applicationFormChip.setEnabled(true);
                }
                else {
                    applicationFormChip.setText(Model.getMessage()+"-"+Model.getStatus());
                }
            }
        });

    }

    private void loginChecker() {
        if(loggedIn){
            loginLayout.setVisibility(View.GONE);
        }
    }


    public void openDrawer(View view) {
    }

    public void admitCardActivity(View view) {
        Intent i = new Intent(this, AdmitCardActivity.class);
        startActivity(i);
    }

    public void fillFormActivity(View view) {

        Intent i = new Intent(this, FillFormActivity.class);
        startActivity(i);
    }

    public void resultActivity(View view) {
    }

    public void loginActivity(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void registerActivity(View view) {

        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}
