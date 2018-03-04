package tex.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button bt,bt2;
    Firebase fb,fb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        fb = new Firebase("https://fir-bd2ed.firebaseio.com/");
        fb1 = new Firebase("https://fir-bd2ed.firebaseio.com/nama");
        bt = (Button)findViewById(R.id.addName);
        bt2 = (Button)findViewById(R.id.button2);
        tv = (TextView)findViewById(R.id.Name);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Firebase firebase = fb.child("nama");
                firebase.setValue("Yusuf");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(inten);
            }
        });
        fb1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tv.setText(""+value);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
