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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button can,regis;
    RequestQueue requestQueue;
    String nom_ub;
    static String corr;


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

                buscar2("https://unoppressive-vibrat.000webhostapp.com/buscar_correo.php?correo="+et2.getText()+"");
                /*
                if (corr.equals(et2.getText().toString()) ){
                    Toast.makeText(getApplicationContext(), "ese correo ya esta", Toast.LENGTH_SHORT).show();
                }else {
                    if (et3.getText().toString().equals( et4.getText().toString())){
                        ejecutarservicio("https://unoppressive-vibrat.000webhostapp.com/insertar.php");
                        nom_ub = et2.getText().toString();
                        Intent siguiente = new Intent(registro.this , agregar_ubi.class);
                        siguiente.putExtra("usu", nom_ub);
                        startActivity(siguiente);
                    }else {
                        Toast.makeText(getApplicationContext(), "contaseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }

                }*/


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
    //aqui la busqueda del correo para ver si existe
    private void buscar2 (String URL){

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {

                        jsonObject = response.getJSONObject(i);
                        //et1.setText(jsonObject.getString("nombre"));
                        //et2.setText(jsonObject.getString("contra"));
                        //corr = jsonObject.getString("correo");

                        //et1.setText("");
                        //et2.setText("");
                        Toast.makeText(getApplicationContext(), "correo ya ingresado", Toast.LENGTH_SHORT).show();
                        et2.setText("");

                        /*
                        if (et3.getText().toString().equals( et4.getText().toString())){
                            ejecutarservicio("https://unoppressive-vibrat.000webhostapp.com/insertar.php");
                            nom_ub = et2.getText().toString();
                            Intent siguiente = new Intent(registro.this , agregar_ubi.class);
                            siguiente.putExtra("usu", nom_ub);
                            startActivity(siguiente);
                        }else {
                            Toast.makeText(getApplicationContext(), "contaseñas no coinciden", Toast.LENGTH_SHORT).show();
                        }
                        */


                    } catch (JSONException e) {
                        //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "correo nuevo", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), "ERROR de conexion al servidor",Toast.LENGTH_SHORT).show();
                if (et3.getText().toString().equals( et4.getText().toString())){
                    ejecutarservicio("https://unoppressive-vibrat.000webhostapp.com/insertar.php");
                    nom_ub = et2.getText().toString();
                    Intent siguiente = new Intent(registro.this , agregar_ubi.class);
                    siguiente.putExtra("usu", nom_ub);
                    startActivity(siguiente);
                }else {
                    Toast.makeText(getApplicationContext(), "contaseñas no coinciden", Toast.LENGTH_SHORT).show();
                }

            }
        }
        );
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }



}
