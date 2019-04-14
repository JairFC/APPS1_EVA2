package jairfranco.com.tec2.pfran.eva2_2_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtRes;
    Intent inSec;

    Intent inOtr;

    final int SECUNDARIA = 1000;
    final int OTRA_ACTIVIDAD = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtRes= findViewById(R.id.tv1);
        inSec = new Intent(this,Secundaria.class);
        inOtr = new Intent(this,OtherActivity.class);
    }

    public void onClick(View v){
       startActivityForResult(inSec,SECUNDARIA);
    }

     public void onclickOth(View v){
         startActivityForResult(inOtr,OTRA_ACTIVIDAD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        //DISTINGUIR LA ACTIVIDAD QUE DEVUELVE EL RESULTADO //REQUESTCODE
         //requestCode
        //SABER SI ENVIO RESULTADOS O CANCELO
          //resultCode
        //PROCESAR LOS DATOS
          //datos (intent)

        if (requestCode == SECUNDARIA){
            if (resultCode == Activity.RESULT_OK){
                //PROCESAR LOS RESULTADO
                //PONERLOS EN EL TV

                String sCade = data.getStringExtra("DATOS");
                txtRes.append("SECUNDARIO"+sCade);

            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "ACCION CANCELADA POR EL USUARIO", Toast.LENGTH_SHORT).show();
            }
        }



      else if (requestCode == OTRA_ACTIVIDAD){
            if (resultCode == Activity.RESULT_OK){
                //PROCESAR LOS RESULTADO
                //PONERLOS EN EL TV

                String sCade = data.getStringExtra("DATOS");
                txtRes.append("OTRA"+sCade);

            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "ACCION CANCELADA POR EL USUARIO", Toast.LENGTH_SHORT).show();
            }
        }








    }
}
