package jairfranco.com.tec2.pfran.eva2_2_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {


    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        etName= findViewById(R.id.etNam);
    }


    public void onClicOk(View v){
        String sCade = etName.getText().toString();
        Intent inDatos = new Intent();

        inDatos.putExtra("DATOS",sCade);
        setResult(Activity.RESULT_OK,inDatos);

        finish();
    }
    public void onClicCancel(View v){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
