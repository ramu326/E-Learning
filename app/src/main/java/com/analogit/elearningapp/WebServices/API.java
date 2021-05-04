package com.analogit.elearningapp.WebServices;

import com.analogit.elearningapp.ApiModel.AllPosterImagesModel;
import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.ApiModel.DailyBoostModel;
import com.analogit.elearningapp.ApiModel.DiagnosticModel;
import com.analogit.elearningapp.ApiModel.DiagnosticPagesModel;
import com.analogit.elearningapp.ApiModel.HomeBannerModel;
import com.analogit.elearningapp.ApiModel.IBAllImagesModel;
import com.analogit.elearningapp.ApiModel.IBSubImagesModel;
import com.analogit.elearningapp.ApiModel.ICardsPagesModel;
import com.analogit.elearningapp.ApiModel.IcardsAudioTopicModel;
import com.analogit.elearningapp.ApiModel.IcardsPastExamsModel;
import com.analogit.elearningapp.ApiModel.IcardsPastExamsTopicsModel;
import com.analogit.elearningapp.ApiModel.IcardsPastExamsTopicsPagesModel;
import com.analogit.elearningapp.ApiModel.IcardsSubjectTopics;
import com.analogit.elearningapp.ApiModel.ListOfCourseModel;
import com.analogit.elearningapp.ApiModel.LogOutModel;
import com.analogit.elearningapp.ApiModel.OptionSelectModel;
import com.analogit.elearningapp.ApiModel.PostLoginModel;
import com.analogit.elearningapp.ApiModel.PosterImageVideoModel;
import com.analogit.elearningapp.ApiModel.PosterSubImagesModel;
import com.analogit.elearningapp.ApiModel.PreLoginModel;
import com.analogit.elearningapp.ApiModel.QbankBookMarkModel;
import com.analogit.elearningapp.ApiModel.QbankModuleOptionModel;
import com.analogit.elearningapp.ApiModel.QbankPastExamsEntraceModel;
import com.analogit.elearningapp.ApiModel.QbankPastExamsWithSubJectsModel;
import com.analogit.elearningapp.ApiModel.QbankSubTopicsModel;
import com.analogit.elearningapp.ApiModel.QbankSubjectModel;
import com.analogit.elearningapp.ApiModel.QuestionOfDayDecModel;
import com.analogit.elearningapp.ApiModel.QuestionOfDayModel;
import com.analogit.elearningapp.ApiModel.RecentUpdateModel;
import com.analogit.elearningapp.ApiModel.RecentUpdatePagesModel;
import com.analogit.elearningapp.ApiModel.RegisterModel;
import com.analogit.elearningapp.ApiModel.SubmitModel;
import com.analogit.elearningapp.ApiModel.SuggestedModel;
import com.analogit.elearningapp.ApiModel.TeachersModel;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.Model.NewIcardsModel;
import com.analogit.elearningapp.NewAdapter.QBankErrorModel;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface API {

    @POST("auth/register/")
    Call<PreLoginModel> getpreLogin(@Body JsonObject v);

    @POST("auth/login/otp/")
    Call<PostLoginModel> getOtpVerify(@Header("Authorization") String token,
                                      @Body JsonObject v, @Header("Content-Type") String content);

    @GET("auth/logout")
    Call<LogOutModel> getlogout(@Header("Authorization") String token,
                                @Header("Content-Type") String content);

    @PUT("auth/registration/update/")
    Call<RegisterModel> getregister(@Header("Authorization") String token,
                                    @Body JsonObject v, @Header("Content-Type") String content);

    @GET("banner/")
    Call<List<HomeBannerModel>> getBanners();

    @GET("question/of/day/")
    Call<QuestionOfDayModel> getQuestionofDay(@Header("Authorization") String token,
                                              @Header("Content-Type") String content);

    @POST("question/of/day/answer/")
    Call<QuestionOfDayDecModel> getQuestionDec(@Header("Authorization") String token,
                                               @Header("Content-Type") String content, @Query("question_id") int ansId,
                                               @Query("ans") String ans);

    @GET("daily/boost/question/")
    Call<List<DailyBoostModel>> getDailyBoostQuestions(
            @Header("Authorization") String token,
            @Header("Content-Type") String content
    );

    @POST("r1/attempts/")
    Call<OptionSelectModel> validateOption(@Body JsonObject v1);

    @GET("r1/attempts/")
    Call<SubmitModel> submit(@Query("user_id") int id,
                             @Query("date") String date);

    @GET("subject/")
    Call<List<AllSubjectModel>> getSubjects(@Header("Authorization") String token,
                                            @Header("Content-Type") String content);

    @GET("subject/image/")
    Call<List<IBSubImagesModel>> getSubImages(@Header("Authorization") String token,
                                              @Header("Content-Type") String content, @Query("subjectId") int id);

    @GET("subject/image/")
    Call<List<IBAllImagesModel>> getAllImages(@Header("Authorization") String token,
                                              @Header("Content-Type") String content);

    @GET("poster/")
    Call<List<AllPosterImagesModel>> getAllPosterImages();

    @GET("poster/")
    Call<List<PosterSubImagesModel>> getsubPosters(@Header("Authorization") String token,
                                                   @Header("Content-Type") String content, @Query("subject_id") int subid);

    @GET("poster/")
    Call<PosterImageVideoModel> getPosterVideo(@Header("Authorization") String token,
                                               @Header("Content-Type") String content, @Query("imageid") int imageId);

    @GET("t1/faculty/")
    Call<List<TeachersModel>> getTech();

    @GET("q1/sub/")
    Call<List<QbankSubjectModel>> getQbankSubjects(@Header("Authorization") String token,
                                                   @Header("Content-Type") String content);


    @GET("q1/bookmark/")
    Call<List<QbankBookMarkModel>> getQbankBookmarks(@Header("Authorization") String token,
                                                     @Header("Content-Type") String content);

    @GET("q1/error/")
    Call<List<QBankErrorModel>> getQbankErrors(@Header("Authorization") String token,
                                               @Header("Content-Type") String content);

    @GET("exam/type/")
    Call<List<QbankPastExamsWithSubJectsModel>> getpastExams(@Query("exam_type") String exam);

    @GET("exam/type/")
    Call<List<QbankPastExamsEntraceModel>> getpastentranceExams(@Query("sid") int id);

    @GET("q1/sub/")
//
    Call<List<QbankSubTopicsModel>> getQbankSubjectTopics(@Header("Authorization") String token,
                                                          @Header("Content-Type") String content, @Query("sid") int id);

    @GET("q1/sub/")
    Call<List<QbankModuleOptionModel>> getQbankoptions(@Query("tid") int tid);

    @GET("suggest/lecture/")
    Call<List<SuggestedModel>> getsuggetdata();

    @GET("suggest/lecture/")
    Call<List<SuggestedModel>> getsuggetVideodata(@Query("id") int id);

    @GET("recent/update/")
    Call<List<RecentUpdateModel>> getRecentUpadte();

    @GET("recent/update/")
    Call<List<RecentUpdatePagesModel>> getRecentUpadtepages(@Query("rid") int id);

    @GET("recent/diagnostic")
    Call<List<DiagnosticModel>> getdiagnostic();

    @GET("recent/diagnostic")
    Call<List<DiagnosticPagesModel>> getdiagnosticpages(@Query("tid") int id);


    @GET("card/isubject/")
    Call<List<NewIcardsModel>> getIcardssub(@Header("Authorization") String token,
                                            @Header("Content-Type") String content);

    @GET("card/isubject/")
    Call<List<IcardsSubjectTopics>> getIcardsTopics(@Header("Authorization") String token,
                                                    @Header("Content-Type") String content, @Query("sid") int id);

    @GET("card/isubject/")
    Call<List<ICardsPagesModel>> getIcardspages(@Header("Authorization") String token,
                                                @Header("Content-Type") String content, @Query("topicid") int id);

    @GET("card/isubject/exam/")
    Call<List<IcardsPastExamsModel>> getIcardPastEaxms(@Header("Authorization") String token,
                                                       @Header("Content-Type") String content);

    @GET("card/isubject/exam/")
    Call<List<IcardsPastExamsTopicsModel>> getIcardPastEaxmsTopics(@Header("Authorization") String token,
                                                                   @Header("Content-Type") String content, @Query("sid") int id);

    @GET("card/isubject/exam/")
    Call<List<IcardsPastExamsTopicsPagesModel>> getIcardPastEaxmsPages(@Header("Authorization") String token,
                                                                       @Header("Content-Type") String content, @Query("examid") int id);

    @GET("card/isubject/audio/")
    Call<List<AudioModel>> getIcardAudio(@Header("Authorization") String token,
                                         @Header("Content-Type") String content);

    @GET("card/isubject/audio/")
    Call<List<IcardsAudioTopicModel>> getIcardAudioTopic(@Query("sid") int id,
                                                         @Header("Authorization") String token,
                                                         @Header("Content-Type") String content);


    @GET("entrance/list/")
    Call<List<ListOfCourseModel>> getcourse();
}
