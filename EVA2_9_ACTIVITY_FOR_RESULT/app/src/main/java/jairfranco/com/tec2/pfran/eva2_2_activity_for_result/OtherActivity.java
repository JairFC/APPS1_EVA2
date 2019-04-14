package jairfranco.com.tec2.pfran.eva2_2_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OtherActivity extends AppCompatActivity {
    EditText etName2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        etName2= findViewById(R.id.etNam2);
    }



    public void onClicOk2(View v){
        String sCade = etName2.getText().toString();
        Intent inDatos = new Intent();

        inDatos.putExtra("DATOS",sCade);
        setResult(Activity.RESULT_OK,inDatos);

        finish();
    }
    public void onClicCancel2(View v){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
