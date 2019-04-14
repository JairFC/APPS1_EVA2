package jairfranco.com.tec2.pfran.eva2_3_intentos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Secundaria extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        i = new Intent(this,MainActivity.class);
    }
    public void onclick2(View v){
        startActivity(i);
        finish();
    }
}
