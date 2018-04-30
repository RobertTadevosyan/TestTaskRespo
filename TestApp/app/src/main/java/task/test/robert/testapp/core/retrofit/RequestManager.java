package task.test.robert.testapp.core.retrofit;

import android.content.Context;

//import com.squareup.okhttp.MediaType;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import task.test.robert.testapp.core.model.Board;
import task.test.robert.testapp.util.Constants;

/**
 * This class is used t divide sending requests process and avoiding to manage response in Activity class
 */

public class RequestManager {

    /**
     * The method sends the GET request to get all board and manages response.
     *
     * @param responseCallback is used to callback method to activity(in which method is called)
     *                         if there is no response or response body is empty will be called onFailure callback in Activity class and will be passed error and error code as params,
     *                         Otherwise will be called success callback and will be passed response data
     */

    public void getAllBoards(final ResponseCallback responseCallback) {
        Call<List<Board>> call = RetrofitHelper.gitHubService().getAllProjects();
        call.enqueue(new Callback<List<Board>>() {
            @Override
            public void onResponse(Call<List<Board>> call, Response<List<Board>> response) {
                if (response.body() != null) {
                    responseCallback.success(response.body());
                } else {
                    try {
                        responseCallback.fail(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                        responseCallback.fail("unknown error", response.code());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Board>> call, Throwable t) {
                responseCallback.fail(t.getLocalizedMessage(), -1);
            }
        });

    }


    /**
     * The method sends the POST request to add new board in server and manages response.
     *
     * @param boardName        is the name of the new board
     * @param responseCallback is used to callback method to activity(in which method is called)
     *                         if there is no response or response body is empty will be called onFailure callback in Activity class and will be passed error and error code as params,
     *                         Otherwise will be called success callback and will be passed response data
     */

    public void addNewBoard(String boardName, final ResponseCallback responseCallback) {
        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=BOUNDARY");
        RequestBody body = RequestBody.create(mediaType, "\r\nContent-Disposition: form-data; name=\"name\"\r\n\r\n" + boardName + "\r\n");
        Call<Board> call = RetrofitHelper.gitHubService().addProject(body);
        call.enqueue(new Callback<Board>() {
            @Override
            public void onResponse(Call<Board> call, Response<Board> response) {
                if (response.body() != null) {
                    responseCallback.success(response.body());
                } else {
                    try {
                        responseCallback.fail(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                        responseCallback.fail("unknown error", response.code());
                    }
                }
            }

            @Override
            public void onFailure(Call<Board> call, Throwable t) {
                responseCallback.fail(t.getLocalizedMessage(), -1);
            }
        });

    }
}
