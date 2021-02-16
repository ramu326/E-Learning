package com.analogit.elearningapp.WebServices;

import com.analogit.elearningapp.ApiModel.AllPosterImagesModel;
import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.ApiModel.DailyBoostModel;
import com.analogit.elearningapp.ApiModel.HomeBannerModel;
import com.analogit.elearningapp.ApiModel.IBAllImagesModel;
import com.analogit.elearningapp.ApiModel.IBSubImagesModel;
import com.analogit.elearningapp.ApiModel.OptionSelectModel;
import com.analogit.elearningapp.ApiModel.PosterImageVideoModel;
import com.analogit.elearningapp.ApiModel.PosterSubImagesModel;
import com.analogit.elearningapp.ApiModel.QuestionOfDayDecModel;
import com.analogit.elearningapp.ApiModel.QuestionOfDayModel;
import com.analogit.elearningapp.ApiModel.SubmitModel;
import com.analogit.elearningapp.ApiModel.TeachersModel;
import com.google.gson.JsonObject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {


    @GET("banner/")
    Call<List<HomeBannerModel>> getBanners();

    @GET("question/of/day/")
    Call<QuestionOfDayModel> getQuestionofDay();

    @POST("question/of/day/answer/")
    Call<QuestionOfDayDecModel>getQuestionDec(@Query("question_id") int ansId,
                                              @Query("ans") String ans);

    @GET ("daily/boost/question/")
    Call<List<DailyBoostModel>> getDailyBoostQuestions();

    @POST("r1/attempts/")
    Call<OptionSelectModel>validateOption(@Body JsonObject v1);

    @GET("r1/attempts/")
    Call<SubmitModel>submit(@Query("user_id")int id,
                            @Query("date") String date);

    @GET("subject/")
    Call<List<AllSubjectModel>> getSubjects();

    @GET("subject/image/")
    Call<List<IBSubImagesModel>>getSubImages(@Query("subjectId") int id);

    @GET("subject/image/")
    Call<List<IBAllImagesModel>>getAllImages();

    @GET("poster/")
    Call<List<AllPosterImagesModel>>getAllPosterImages();

    @GET("poster/")
    Call<List<PosterSubImagesModel>>getsubPosters(@Query("subject_id")int subid);

    @GET("poster/")
    Call<PosterImageVideoModel>getPosterVideo(@Query("imageid")int imageId);

    @GET("t1/faculty/")
    Call<List<TeachersModel>>getTech();



}
