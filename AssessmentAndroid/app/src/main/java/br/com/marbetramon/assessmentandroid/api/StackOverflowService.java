package br.com.marbetramon.assessmentandroid.api;

import br.com.marbetramon.assessmentandroid.model.TagList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface StackOverflowService {

    @GET("/questions?order=desc&sort=activity&site=stackoverflow")
    Call<TagList> getTags(@Query("tagged") String tag);

}