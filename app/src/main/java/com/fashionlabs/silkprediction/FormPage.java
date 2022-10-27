package com.fashionlabs.silkprediction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String selectedSilks = "";
    int count = 0;
    String others;
    LinearLayout other;
    Button submit;
    public DocumentReference docRef;
    public FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Activity activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_page);
        RadioGroup group = findViewById(R.id.radioGroup);
        Spinner spinner = findViewById(R.id.spinner);
        submit = findViewById(R.id.submit);
        submit.setEnabled(false);
        other = findViewById(R.id.others);
        EditText ed = findViewById(R.id.editTextTextPersonName);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() >= 3)
                {
                    submit.setEnabled(true);
                }
                else
                {
                    submit.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!selectedSilks.equals("Others")) {
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    System.out.println(document.get(selectedSilks));
                                    count = (document.getDouble(selectedSilks)).intValue();
                                    Map<String, Object> data = new HashMap<>();
                                    data.put(selectedSilks, count + 1);
                                    docRef.set(data, SetOptions.merge());
                                    Intent i = new Intent(activity, MainActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    Toast.makeText(activity, "Submitted Successfully", Toast.LENGTH_LONG).show();
                                    startActivity(i);
                                }
                            }
                        }
                    });
                }
               else
               {
                   Map<String, Object> data = new HashMap<>();
                   data.put(others,"1");
                   docRef.set(data, SetOptions.merge());
                   Intent i = new Intent(activity, MainActivity.class);
                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |  Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   Toast.makeText(activity, "Submitted Successfully", Toast.LENGTH_LONG).show();
                   startActivity(i);

               }
            }
        });
        List<String> mensCategories = new ArrayList<String>();
        mensCategories.add("Silk shirts");
        mensCategories.add("Ties");
        mensCategories.add("Robes");
        mensCategories.add("Formal wear");
        mensCategories.add("Silk khadi");
        mensCategories.add("Kurtas");
        mensCategories.add("Pyjama");
        mensCategories.add("Others");
        List<String> womens = new ArrayList<>();
        womens.add("Wedding dresses");
        womens.add("Festive gowns");
        womens.add("Blouses");
        womens.add("Traditional outfits");
        womens.add("Scarves");
        womens.add("Lingerie");
        womens.add("Others");
        spinner.setOnItemSelectedListener(this);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                submit.setEnabled(true);
                ArrayAdapter<String> dataAdapter;
                if(group.getCheckedRadioButtonId() == R.id.Male)
                {
                    dataAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, mensCategories);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    docRef= db.collection("mensSilks").document("PfW90EEebMESlfHwROl5");
                    spinner.setAdapter(dataAdapter);
                }
                else if (group.getCheckedRadioButtonId() == R.id.Female)
                {
                    dataAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, womens);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    docRef= db.collection("womenSIlks").document("bIGKUQPjy9V1LZpVqHpU");
                    spinner.setAdapter(dataAdapter);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        selectedSilks = item;
        if (selectedSilks.equals("Others"))
        {
            other.setVisibility(View.VISIBLE);
            submit.setEnabled(false);
        }
        else
        {
            other.setVisibility(View.GONE);
        }
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}