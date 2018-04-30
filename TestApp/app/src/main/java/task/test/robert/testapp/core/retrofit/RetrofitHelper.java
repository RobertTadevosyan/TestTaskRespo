package task.test.robert.testapp.core.retrofit;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import task.test.robert.testapp.util.Constants;


/**
 * This class manages Retrofit library and sets android http client
 */
public class RetrofitHelper {
    private static GitHubService gitHubService;


    /**
     * This methods sets android http client, headers and other configurations
     */
    public static GitHubService gitHubService() {
        if (gitHubService == null) {
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + Constants.TOKEN)
                            .build();
                    return chain.proceed(newRequest);
                }
            }).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            gitHubService = retrofit.create(GitHubService.class);
        }
        return gitHubService;
    }

}
