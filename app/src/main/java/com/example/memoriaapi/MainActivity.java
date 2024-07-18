package com.example.memoriaapi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.memoriaapi.interfaces.EstadosAPI;
import com.example.memoriaapi.models.Estados;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvIntentos;
    TextView tvCorrectos;
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIntentos=findViewById(R.id.tvIntentos);
        tvCorrectos=findViewById(R.id.tvCorrectos);
        btnBuscar=findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find("1");
            }
        });
    }
    private void find(String codigo){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://192.168.1.229/API/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        EstadosAPI estadoAPI=retrofit.create(EstadosAPI.class);
        Call<Estados> call=estadoAPI.find(codigo);
        call.enqueue(new Callback<Estados>() {
            @Override
            public void onResponse(Call<Estados> call, Response<Estados> response) {
                try {
                    if (response.isSuccessful()) {
                        Estados p = response.body();
                        tvCorrectos.setText(p.getCorrectos());
                        tvIntentos.setText(p.getIntentos());
                    }
                } catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Estados> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexiónes",Toast.LENGTH_SHORT).show();
            }
        });
    }
}