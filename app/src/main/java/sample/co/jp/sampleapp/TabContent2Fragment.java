package sample.co.jp.sampleapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import sample.co.jp.sampleapp.net.ApiIF;


public class TabContent2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view =  inflater.inflate(R.layout.fragment_tab_content2, container, false);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi2();
            }
        });

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi3();
            }
        });

        //assetから直接画像をpostできないので、内部ストレージにコピーする
        copyAssetsFile();

        return view;
    }

    private void callApi() {
        ApiIF rest_client = createRestClient();

        rest_client.index("yamada", "taro").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // 成功時の処理
                Toast.makeText(getContext() , "成功しました。", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // 成功時の処理
                Toast.makeText(getContext() , "失敗しました。", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void callApi2() {
        ApiIF rest_client = createRestClient();

        File file = new File(getContext().getFilesDir() + "/tmp.jpg");
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), requestFile);

        rest_client.index2(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // 成功時の処理
                Toast.makeText(getContext() , "成功しました。", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("hoge", t.getMessage());

                // 成功時の処理
                Toast.makeText(getContext() , "失敗しました。", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void callApi3() {
        ApiIF rest_client = createRestClient();

        RequestBody requestName = RequestBody.create(MediaType.parse("multipart/form-data"), "hoge");
        RequestBody requestKana = RequestBody.create(MediaType.parse("multipart/form-data"), "hogahoga");

        File file = new File(getContext().getFilesDir() + "/tmp.jpg");
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part requestImage = MultipartBody.Part.createFormData("image", file.getName(), requestFile);

        rest_client.index3(requestName, requestKana, requestImage).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // 成功時の処理
                Toast.makeText(getContext() , "成功しました。", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("hoge", t.getMessage());

                // 成功時の処理
                Toast.makeText(getContext() , "失敗しました。", Toast.LENGTH_LONG).show();
            }
        });
    }

    private ApiIF createRestClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://dev.e-2.jp/tamura/er_m/");
        Retrofit retrofit = builder.client(httpClient.build()).build();

        return retrofit.create(ApiIF.class);
    }

    private void copyAssetsFile() {
        try {
            InputStream inputStream = getResources().getAssets().open("tmp.jpg");
            FileOutputStream fileOutputStream = getActivity().openFileOutput("tmp.jpg", Context.MODE_PRIVATE);

            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) >= 0) {
                fileOutputStream.write(buffer, 0, length);
            }

            fileOutputStream.close();
            inputStream.close();
        }
        catch (IOException e) {
        }
    }
}