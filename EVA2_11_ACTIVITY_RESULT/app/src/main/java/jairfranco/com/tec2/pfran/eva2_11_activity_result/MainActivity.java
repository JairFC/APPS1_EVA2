package jairfranco.com.tec2.pfran.eva2_11_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResu;
    Intent inCaptura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResu = findViewById(R.id.tvResu);
        inCaptura = new Intent(this,Captura.class);
    }


        public void onClickCapt(View v) {
            startActivityForResult(inCaptura,1000);
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            if (resultCode == Activity.RESULT_OK){

                tvResu.append("Nombre: " + data.getStringExtra("NOMBRE") +
                        "\nApellido: " + data.getStringExtra("APELLIDO") +
                        "\nMaterias: " + data.getStringExtra("MATERIAS"));
            }
        }
    }
}
