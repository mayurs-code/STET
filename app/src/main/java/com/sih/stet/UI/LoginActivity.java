package com.sih.stet.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.sih.stet.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {


    TextInputEditText applicationNumberLoginField;
    TextInputEditText passwordLoginField;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Context context;
    SharedPreferences preferences;
    String applicationNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        members();
    }

    private void members() {
        preferences = getPreferences(Context.MODE_PRIVATE);
        applicationNumberLoginField = findViewById(R.id.applicationNumberLoginField);
        passwordLoginField = findViewById(R.id.passwordLoginField);
    }

    public void loginUser(View view) {
        applicationNumber = applicationNumberLoginField.getText().toString().trim();
        db.collection("users").whereEqualTo("application_no", applicationNumber).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.getResult().size() >= 1) {
                    DocumentSnapshot snapshot = Objects.requireNonNull(task.getResult()).getDocuments().get(0);
                    if (snapshot.exists()) {
                        if (snapshot.getString("password").equals(passwordLoginField.getText().toString())) {
                            preferences.edit().putString("applicationNumber", applicationNumber).apply();
                            Toast.makeText(context, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            preferences.edit().putString("applicationNumber", "---").apply();
                            preferences.edit().apply();

                            Toast.makeText(context, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "No Application ID found", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(context, "No Application ID found", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    public void registerActivity(View view) {
    }
}
