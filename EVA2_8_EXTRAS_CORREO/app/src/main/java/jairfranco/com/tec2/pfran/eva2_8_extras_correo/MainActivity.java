package jairfranco.com.tec2.pfran.eva2_8_extras_correo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etAsu,etDest,etMens;

    Button btnEnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAsu = findViewById(R.id.etAsunt);
        etDest = findViewById(R.id.etDestin);
        etMens = findViewById(R.id.etMens);

        btnEnv = findViewById(R.id.btnEnv);

        btnEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailSubject = etAsu.getText().toString();
                String emailText =etMens.getText().toString();

                String[] emailReceiverList = {etDest.getText().toString()};
                Intent intent = new Intent(Intent.ACTION_SEND);
                
                intent.setType("vnd.android.cursor.dir/email");
                intent.putExtra(Intent.EXTRA_EMAIL, emailReceiverList);
                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailText);
                startActivity(Intent.createChooser(intent,
                        "To complete action choose:"));
            }
        });
    }
}
