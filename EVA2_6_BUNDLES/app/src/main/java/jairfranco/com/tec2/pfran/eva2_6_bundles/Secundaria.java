package jairfranco.com.tec2.pfran.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class Secundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        Intent iDatos = getIntent();
        Bundle bDatos = iDatos.getExtras();

        Toast.makeText(this, "Nombre: "+bDatos.get("NOMBRE")+"", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Estatura: "+bDatos.get("ESTATURA")+"", Toast.LENGTH_SHORT).show();

    }
}
