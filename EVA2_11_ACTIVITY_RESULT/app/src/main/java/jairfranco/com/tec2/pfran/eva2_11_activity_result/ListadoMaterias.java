package jairfranco.com.tec2.pfran.eva2_11_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListadoMaterias extends AppCompatActivity implements ListView.OnItemClickListener{

    ListView lstMaterias;
    String[] asMaterias ={
            "Fundamentos de programacion",
            "Programacion orientada a objetos",
            "Estructura de datos",
            "Topicos avanzados de programacion",
            "Graficacion",
            "Programacion Web",
            "Apps1",
            "Apps2",
            "Apps3",
            "Apps Hibridas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_materias);

        lstMaterias = findViewById(R.id.list1);

        lstMaterias.setAdapter(new ArrayAdapter<String>(

                this,
                android.R.layout.simple_list_item_1,
                asMaterias
        ));


        lstMaterias.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inDatos = new Intent();
        inDatos.putExtra("MATERIA",asMaterias[position]+"\n");
        setResult(Activity.RESULT_OK,inDatos);
        finish();
    }
}
