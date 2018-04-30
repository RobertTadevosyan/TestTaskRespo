package task.test.robert.testapp.core.retrofit;


import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import task.test.robert.testapp.core.model.Board;


/**
 * This class contains all requests signatures.
 */

public interface GitHubService {

    /**
     * GET request endpoint - api/patagonia/boards.
     * Requests an Array of Board class objects
     */
    @GET("api/patagonia/boards")
    Call<List<Board>> getAllProjects();


    /**
     * POST request endpoint - api/patagonia/boards.
     * Requests to put an Board class object in the server and will get the added object
     * @param body contains headers and board name
     */
    @POST("api/patagonia/boards")
    Call<Board> addProject(
            @Body RequestBody body);

}

