package com.example.iot;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiInterface {
    @GET("datacuaca.php") // Endpoint untuk file datacuaca.php
    Call<List<DataCuaca>> getDataCuaca();
}
