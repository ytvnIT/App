package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.Retrofit.APIUtils;
import com.example.login.Retrofit.DataClient;

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
//
                DataClient dataClient= APIUtils.getData();

//                Call<String> callback=dataClient.get();
                String mahv=et_user.getText().toString(), password=et_password.getText().toString();

                if(mahv.trim().length()==0 || password.trim().length()==0)
                    Toast.makeText(Activity_Login.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                else {

                    Call<String> callback = dataClient.signin(mahv, password);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if (response != null) {
                                String message = response.body();
                                Log.d("BBB", message);
                                if(message.equals("success")) {
                                    Toast.makeText(Activity_Login.this, message, Toast.LENGTH_SHORT).show();
                                    Intent intent_Menu = new Intent(Activity_Login.this, Activity_Menu.class);
                                     startActivity(intent_Menu);
                                }
                                else
                                    Toast.makeText(Activity_Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                                    et_user.setText("");
                                    et_password.setText("");
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("BBB", t.getMessage());
                        }
                    });
                }
//                Toast.makeText(Activity_Login.this, "Bạn đã đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            }
        });



    }



    private void Anhxa() {
        et_user = (EditText) findViewById(R.id.et_MSSV_fg);
        et_password = (EditText) findViewById(R.id.et_Password);
        btn_Login2 = (Button) findViewById(R.id.btn_Send_fg);
        btn_back = (Button) findViewById(R.id.btn_back_fg); // Button back
    }
}
