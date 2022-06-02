package com.example.practicat3;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Servicios {

    @GET("addLibro")
    Call<libro> getEntrenador();

    @POST("addLibro")
    Call<Void> postCrearLibri(@Body libro libro);
}
