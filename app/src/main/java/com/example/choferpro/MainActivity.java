package com.example.choferpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btn_reg,btn_ent;
    RequestQueue requestQueue;
    String nom_c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        btn_ent=(Button)findViewById(R.id.btn_ent);
        btn_reg=(Button)findViewById(R.id.btn_reg);

        btn_ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar("https://unoppressive-vibrat.000webhostapp.com/log.php?correo="+et1.getText()+"&contra="+et2.getText()+"");
                nom_c = et1.getText().toString();
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(MainActivity.this , registro.class);
                //siguiente.putExtra("usu", ban);
                startActivity(siguiente);
            }
        });

    }
    private void buscar (String URL){

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {

                        jsonObject = response.getJSONObject(i);
                        //et1.setText(jsonObject.getString("nombre"));
                        //et2.setText(jsonObject.getString("contra"));

                        Intent siguiente = new Intent(MainActivity.this , agregar_ubi.class);
                        siguiente.putExtra("usu", nom_c);
                        startActivity(siguiente);

                        et1.setText("");
                        et2.setText("");


                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR de conexion con el usuario",Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


}
