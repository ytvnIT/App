package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.login.Retrofit.APIUtils;
import com.example.login.Retrofit.DataClient;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Login extends AppCompatActivity {

    Button btn_back, btn_Login2;
    EditText et_user,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);

        Anhxa(); //Hàm ánh xạ các thuộc tính trên màn hình

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_back = new Intent(Activity_Login.this, MainActivity.class);
                startActivity(intent_back);
            }
        });

        btn_Login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent_Menu = new Intent(Activity_Login.this, Activity_Menu.class);
//                startActivity(intent_Menu);
                DataClient dataClient= APIUtils.getData();

//                Call<String> callback=dataClient.get();
                Call<String> callback=dataClient.signin("17520001", "123");
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response!=  null){
                            String message=response.body();
                            Log.d("BBB",message);
                            Toast.makeText(Activity_Login.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("BBB",t.getMessage());
                    }
                });
//                Toast.makeText(Activity_Login.this, "Bạn đã đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            }
        });



    }



    private void Anhxa() {
        et_user = (EditText) findViewById(R.id.et_MSSV);
        et_password = (EditText) findViewById(R.id.et_Password);
        btn_Login2 = (Button) findViewById(R.id.btn_Login2);
        btn_back = (Button) findViewById(R.id.btn_back); // Button back
    }
}
