package com.example.login.Retrofit;

public class APIUtils {
//    public static final String Base_Url="http:172.30.99.190:8000";
public static final String Base_Url="http://10.80.253.89:8000";



    //nhan va gui data di, lam trung gian cho interface
    public static DataClient getData(){
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
