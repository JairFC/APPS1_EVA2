package jairfranco.com.tec2.pfran.password;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAcc;
   // Button btnSalir;

    private String usuario="jair";
    private String contraseña="xxxx.123";

    int[] asImages = {
            R.drawable.androidlogo,
            R.drawable.world,
            R.drawable.space,
            R.drawable.debian,
            R.drawable.camera,
            R.drawable.tecnm,
            R.drawable.question,
    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAcc = findViewById(R.id.btnAcceso);

        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int item = asImages[(int) Math.floor(Math.random()*asImages.length)];

                final Dialog dlgMiDialogo;

                dlgMiDialogo = new Dialog(MainActivity.this);

                dlgMiDialogo.setContentView(R.layout.cuadro_dialogo);


                final EditText etUser,etPass;
                Button btnOK,btnCancel;
                ImageView imagen2;

                imagen2 = dlgMiDialogo.findViewById(R.id.imageLogin);
                imagen2.setImageResource(item);


                etUser = dlgMiDialogo.findViewById(R.id.etUser);
                etPass = dlgMiDialogo.findViewById(R.id.etPass);

                btnOK = dlgMiDialogo.findViewById(R.id.btnok);
                btnCancel = dlgMiDialogo.findViewById(R.id.btncancel);


                etUser.setHint("introduce tu nombre");
                etPass.setHint("introduce tu contraseña");


                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sName,sPass;

                        sName = etUser.getText().toString();
                        sPass = etPass.getText().toString();

                        if (sName.equals(usuario)&& sPass.equals(contraseña)){
                            Intent i = new Intent(MainActivity.this,Principal.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(MainActivity.this, "El Usuario y/o Contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dlgMiDialogo.dismiss();
                    }
                });

                dlgMiDialogo.show();
            }
        });
    }


}
