package sample.co.jp.sampleapp.net;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiIF {
    /**
     * フォーム文字列だけ
     */
    @Headers({
            "Accept: application/json",
    })
    @FormUrlEncoded
    @POST("image_form.php")
    Call<ResponseBody> index (
            @Field("name") String name,
            @Field("kana") String kana
    );

    /**
     * 画像だけ
     */
    @Headers({
            "Accept: application/json",
    })
    @Multipart
    @POST("image_form.php")
    Call<ResponseBody> index2 (
            @Part MultipartBody.Part image
    );

    /**
     * 画像と文字列
     */
    @Headers({
            "Accept: application/json",
    })
    @Multipart
    @POST("image_form.php")
    Call<ResponseBody> index3 (
            @Part("name") RequestBody name,
            @Part("kana") RequestBody kana,
            @Part MultipartBody.Part image
    );
}

