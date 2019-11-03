package com.example.login.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.Retrofit.APIUtils;
import com.example.login.Retrofit.DataClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Forgotpassword extends AppCompatActivity {

    Button btnSend, btnBack;
    EditText etId;
    DataClient dataClient= APIUtils.getData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__forgotpassword);
        Anhxa();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id=etId.getText().toString();
                Call<String> callback = dataClient.reset(Id);
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String message=response.body();
                        Toast.makeText(Activity_Forgotpassword.this, message, Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });

    }

    public void Anhxa() {
        btnSend=findViewById(R.id.btn_Send_fg);
        etId=findViewById(R.id.et_MSSV_fg);
        btnBack=findViewById(R.id.btn_back_fg);

    }

}
