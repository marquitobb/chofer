package com.example.choferpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ubicaciones extends AppCompatActivity {

    String nomu;
    RequestQueue requestQueue;
    ListView lv1;
    Button btn_agre,salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);

        btn_agre=(Button)findViewById(R.id.btn_agre);
        salir=(Button)findViewById(R.id.salir);

        lv1 = (ListView)findViewById(R.id.lv1);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
            nomu= b.getString("usuar");

        }

        EnviarRecibirDatos("https://unoppressive-vibrat.000webhostapp.com/consultar_ubi.php?correo="+nomu+"");

        btn_agre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(ubicaciones.this , agregar_ubi.class);
                startActivity(siguiente);

            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(ubicaciones.this , MainActivity.class);
                startActivity(siguiente);

            }
        });
    }
    public void EnviarRecibirDatos(String URL){

        Toast.makeText(getApplicationContext(), "bienvenido a nuestros productos",Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        CargarListView(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

    }
    public void CargarListView(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=4){

            try {

                lista.add(ja.getString(i)+" "+ja.getString(i+1)/*+" "+ja.getString(i+2)*/);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        lv1.setAdapter(adaptador);

    }


}
