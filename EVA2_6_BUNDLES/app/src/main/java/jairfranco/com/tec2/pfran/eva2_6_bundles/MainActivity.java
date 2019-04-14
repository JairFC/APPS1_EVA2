package jairfranco.com.tec2.pfran.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Intent iSec;

    Button btnSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iSec = new Intent(this, Secundaria.class);
        btnSec = findViewById(R.id.btnsec);
    }

    public void onClick(View v){

        Bundle bDatos = new Bundle();
        bDatos.putString("NOMBRE","Jair Franco");
        bDatos.putDouble("ESTATURA",2.47);

        iSec.putExtras(bDatos);

        startActivity(iSec);

    }
}
