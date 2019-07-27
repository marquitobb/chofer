package com.example.choferpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button can,regis;
    RequestQueue requestQueue;
    String nom_ub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);

        can=(Button)findViewById(R.id.can);
        regis=(Button)findViewById(R.id.regis);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (et1.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "ingresa un usuario", Toast.LENGTH_SHORT).show();
                }
                if (et2.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "ingresa una contraseña", Toast.LENGTH_SHORT).show();
                }
                if (et3.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "ingresa un numero", Toast.LENGTH_SHORT).show();
                }
                if (et4.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "ingresa un correo", Toast.LENGTH_SHORT).show();
                }
                if (et1.getText().toString().trim().length() != 0 && et2.getText().toString().trim().length() != 0
                        && et3.getText().toString().trim().length() != 0 && et4.getText().toString().trim().length() != 0){

                    ejecutarservicio("https://pepelismc.000webhostapp.com/insertar.php");
                    Intent siguiente = new Intent(registro.this , MainActivity.class);
                    startActivity(siguiente);
                }*/



                ejecutarservicio("https://unoppressive-vibrat.000webhostapp.com/insertar.php");
                nom_ub = et2.getText().toString();
                Intent siguiente = new Intent(registro.this , agregar_ubi.class);
                siguiente.putExtra("usu", nom_ub);
                startActivity(siguiente);
            }
        });

        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sig = new Intent(registro.this , MainActivity.class);
                startActivity(sig);

            }
        });


    }

    private void ejecutarservicio(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "operacion exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombre",et1.getText().toString());
                parametros.put("correo",et2.getText().toString());
                parametros.put("contra",et3.getText().toString());


                return parametros;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
