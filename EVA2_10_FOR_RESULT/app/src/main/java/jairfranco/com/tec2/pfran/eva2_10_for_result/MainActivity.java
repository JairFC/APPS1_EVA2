package jairfranco.com.tec2.pfran.eva2_10_for_result;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    EditText txtProvider;
    TextView txtExample;
    Button btnCallActivity2;

    Uri[] uriProvider = {
//            Uri.parse("content://media/external/audio/media"),
//            Uri.parse("content://media/external/images/media"),
            android.provider.ContactsContract.Contacts.CONTENT_URI,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            txtMsg = (TextView) findViewById(R.id.txtMsg);
            txtProvider = (EditText) findViewById(R.id.txtProviderOption);

            // show some examples of built-in content providers
            txtExample = (TextView) findViewById(R.id.txtExample);


            for (int i = 0; i < uriProvider.length; i++)
                txtExample.append("\n" + i + " "
                        + uriProvider[i].toString());


            btnCallActivity2 = (Button) findViewById(R.id.btnOption);
            btnCallActivity2.setOnClickListener(new ClickHandler());
        } catch (Exception e) {

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case (222): {
                    if (resultCode == Activity.RESULT_OK) {
                        String returnedData = data.getDataString();

                       //mostramos el id seleccionado
                        //Toast.makeText(getApplication(), "id " + returnedData, Toast.LENGTH_SHORT).show();

                        txtMsg.setText(returnedData.toString());

                        // ejecutamos un intento para ver el objeto seleccionado
                        Intent myAct3 = new Intent(Intent.ACTION_VIEW,Uri.parse(returnedData));
                        startActivity(myAct3);

                    } else {

                    }
                    break;
                }
            }
        } catch (Exception e) {

        }
    }

    public class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            try {
                int option = Integer.parseInt(txtProvider.getText().toString());
                Intent myActivity2 = new Intent(Intent.ACTION_PICK,
                        uriProvider[option]);
                startActivityForResult(myActivity2, 222);
            } catch (Exception e) {

            }
        }
    }

}




