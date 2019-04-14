package jairfranco.com.tec2.pfran.eva2_1_intentos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent inMarcar,inBus,inMen;
    EditText edtTxtNum,edtTxtSearch,edtTxtSms,edtTxtNumSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtNum = findViewById(R.id.edtTxtNum);
        edtTxtSearch = findViewById(R.id.editText2);
        edtTxtSms = findViewById(R.id.edtTxtSms);
        edtTxtNumSms = findViewById(R.id.edtTxtNumSms);

    }

    public void onClick(View v){

        String sTel = "tel:"+edtTxtNum.getText().toString();
        inMarcar = new Intent(Intent.ACTION_DIAL, Uri.parse(sTel));
        //Iniciar la actividad depden si solicitan o n resultados
        //Sin resultados
        startActivity(inMarcar);
        //Con resultados startActivityForResult

    }

    public void onClickLlamda(View v){

        String sTel = "tel:"+edtTxtNum.getText().toString();
        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        //Iniciar la actividad depden si solicitan o n resultados
        //Sin resultados
        startActivity(inMarcar);
        //Con resultados startActivityForResult

    }
    public void onClickSearch(View v){
        //Recuperar info de usuariio
        String sBus = edtTxtSearch.getText().toString();
        //Generar el intento
        inBus = new Intent(Intent.ACTION_WEB_SEARCH);
        inBus.putExtra(SearchManager.QUERY,sBus);
        startActivity(inBus);
    }
    public void onClickSms(View v){
        String sTel = "smsto:"+edtTxtNumSms.getText().toString();
        String sMen = edtTxtSms.getText().toString();

        inMen = new Intent(Intent.ACTION_SENDTO,Uri.parse(sTel));
        inMen.putExtra("sms_body",sMen);
        startActivity(inMen);
    }
}