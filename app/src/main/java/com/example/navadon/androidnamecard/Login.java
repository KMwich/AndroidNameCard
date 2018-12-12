package com.example.navadon.androidnamecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = FirebaseDatabase.getInstance();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.search) {
            EditText editText = (EditText) findViewById(R.id.searchText);
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                DatabaseReference ref = db.getReference().child(text);
                Log.d("Fuck", "onClick: " + ref.toString());
                try {
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            getData(dataSnapshot);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) { }
                    });
                } catch (Exception e) {
                    Log.w("Fuck", "onClick: " + e.getMessage());
                }
            }
        }
    }

    private void getData(DataSnapshot dataSnapshot) {
        if (dataSnapshot.child("name").getValue() == null) {
            return;
        }

        String fname = dataSnapshot.child("name").getValue().toString();
        String lname = dataSnapshot.child("lastname").getValue().toString();
        String position = dataSnapshot.child("position").getValue().toString();
        String email = dataSnapshot.child("email").getValue().toString();
        String phone = dataSnapshot.child("phone").getValue().toString();
        String ui = dataSnapshot.child("ui").getValue().toString();
        String color1 = dataSnapshot.child("color2").getValue().toString();
        String color2 = dataSnapshot.child("color3").getValue().toString();

        new Model(fname, lname, position, email, phone, ui, color1, color2);
        startActivity(new Intent(this,Card1.class));
    }

}
