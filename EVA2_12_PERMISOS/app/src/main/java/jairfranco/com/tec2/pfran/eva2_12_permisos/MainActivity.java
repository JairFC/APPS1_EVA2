package jairfranco.com.tec2.pfran.eva2_12_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    EditText etNum;
    Button btnCall;

    Intent intent;

    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum=findViewById(R.id.etNum);
        btnCall=findViewById(R.id.btnCall);



        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            }
            else
            {
                Toast.makeText(this, "PERMISOS DE LLAMADA CONFIRMADOS", Toast.LENGTH_SHORT).show();

                // startActivity(intent);
            }
        }else{
//              startActivity(intent);
            Toast.makeText(this, "Version menor a .M", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_CALL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   //
                    Toast.makeText(this, "PERMISOS DE LLAMADA CONFIRMADOS", Toast.LENGTH_SHORT).show();

                }
                else
                {

                }
                return;
            }
        }
    }


    public void clickCall(View v){

        String numerofinal = etNum.getText().toString();
        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+numerofinal));

        startActivity(intent);
    }
}
