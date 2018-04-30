package task.test.robert.testapp.core.retrofit;

/**
 * This interface(class) is used to send request result from request manager to the classes where request was executes.
 */

public interface ResponseCallback {

    /**
     * The method should be called if there is response and the last one has body(data).
     *
     * @param object is the response data
     */
    void success(Object object);


    /**
     * The method should be called if there is no response or the last one has no body(data).
     *
     * @param error     is the reason, why the response has no data
     * @param errorCode is code of the error from server
     */
    void fail(String error, int errorCode);
}
