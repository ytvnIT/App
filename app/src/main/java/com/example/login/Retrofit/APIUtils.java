package com.example.login.Retrofit;

public class APIUtils {
    public static final String Base_Url="http:192.168.240.1:8000";
//public static final String Base_Url="http:10.10.255.192:8000";



    //nhan va gui data di, lam trung gian cho interface
    public static DataClient getData(){
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
