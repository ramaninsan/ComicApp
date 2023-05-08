package ratofit;

import com.example.capstone.dataClasses.RegClass;
import com.example.capstone.loginAndReg.LoginActivity;


import Pojos.HeaderAllComics;
import Pojos.LoginResponse;
import Pojos.ProfileModel;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

public interface RestService {



    @Headers("Content-Type: application/json")
    @POST("/User/login/User")
    public void doLogin(@Body LoginActivity.LoginModel loginModel, Callback<LoginResponse> callback);


    @Headers("Content-Type: application/json")
    @POST("/User/Register")
    public void doRegister(
                           @Body RegClass task,
                           Callback<LoginResponse> callback
                           );



    @GET("/Comic/comics/all")
    void getAllComics(Callback<HeaderAllComics> callback);


    @Headers("token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiI5OTAyZmVmNS0yYWYxLTRmYTAtOTk0Zi0xNzNlNGNkMjdjNDgiLCJqdGkiOiJkZjMzZmM3MS1kZjUyLTQ1NGQtYmRjNC02NWU2NzUxY2RiMDIiLCJlbWFpbCI6InJhbWFuQGdtYWlsLmNvbSIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IlVzZXIiLCJleHAiOjE2ODE3NzY3NTQsImlzcyI6IkNvbWljQ3JhenkiLCJhdWQiOiJDb21pY0NyYXp5QXVkaWVuY2UifQ.aMQk57AhttLpqQrR8tOFS6eXVcoBFi1JVD2AKYMh-T8")
    @GET("/User/Profile")
    void getProfile(Callback<ProfileModel> callback);





    @FormUrlEncoded
    @POST("/makeComic")
    public void makeComic(@Field("username") String username, @Field("email") String email, @Field("password") String password, @Field("user") String user, Callback<LoginResponse> callback);

    @FormUrlEncoded
    @POST("/profileInfo")
    public void userInfo(@Field("username") String username, @Field("email") String email, @Field("password") String password, @Field("user") String user, Callback<LoginResponse> callback);


    @FormUrlEncoded
    @POST("/userUpdate")
    public void updateInfo(@Field("username") String username, @Field("email") String email, @Field("password") String password, @Field("user") String user, Callback<LoginResponse> callback);






}
