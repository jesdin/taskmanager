/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.jesdin.taskmanager.mytaskapi;

import com.jesdin.taskmanager.mytaskapi.models.MyTask;
import com.microsoft.rest.RestException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import rx.Observable;
import com.microsoft.rest.RestClient;

/**
 * The interface for MyAPI class.
 */
public interface MyAPI {
    /**
     * Gets the REST client.
     *
     * @return the {@link RestClient} object.
    */
    RestClient restClient();

    /**
     * The default base URL.
     */
    String DEFAULT_BASE_URL = "https://";

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;MyTask&gt; object if successful.
     */
    List<MyTask> getMyTask();

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<List<MyTask>> getMyTaskAsync(final ServiceCallback<List<MyTask>> serviceCallback);

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MyTask&gt; object
     */
    Observable<List<MyTask>> getMyTaskAsync();

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MyTask&gt; object
     */
    Observable<ServiceResponse<List<MyTask>>> getMyTaskWithServiceResponseAsync();

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void postMyTask();

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> postMyTaskAsync(final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> postMyTaskAsync();

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> postMyTaskWithServiceResponseAsync();
    /**
     *
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void postMyTask(MyTask myTask);

    /**
     *
     * @param myTask the MyTask value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> postMyTaskAsync(MyTask myTask, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> postMyTaskAsync(MyTask myTask);

    /**
     *
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> postMyTaskWithServiceResponseAsync(MyTask myTask);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the MyTask object if successful.
     */
    MyTask getMyTask1(int id);

    /**
     *
     * @param id the int value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<MyTask> getMyTask1Async(int id, final ServiceCallback<MyTask> serviceCallback);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MyTask object
     */
    Observable<MyTask> getMyTask1Async(int id);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MyTask object
     */
    Observable<ServiceResponse<MyTask>> getMyTask1WithServiceResponseAsync(int id);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the MyTask object if successful.
     */
    MyTask putMyTask(int id);

    /**
     *
     * @param id the int value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<MyTask> putMyTaskAsync(int id, final ServiceCallback<MyTask> serviceCallback);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MyTask object
     */
    Observable<MyTask> putMyTaskAsync(int id);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MyTask object
     */
    Observable<ServiceResponse<MyTask>> putMyTaskWithServiceResponseAsync(int id);
    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the MyTask object if successful.
     */
    MyTask putMyTask(int id, MyTask myTask);

    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<MyTask> putMyTaskAsync(int id, MyTask myTask, final ServiceCallback<MyTask> serviceCallback);

    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MyTask object
     */
    Observable<MyTask> putMyTaskAsync(int id, MyTask myTask);

    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the MyTask object
     */
    Observable<ServiceResponse<MyTask>> putMyTaskWithServiceResponseAsync(int id, MyTask myTask);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void deleteMyTask(int id);

    /**
     *
     * @param id the int value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    ServiceFuture<Void> deleteMyTaskAsync(int id, final ServiceCallback<Void> serviceCallback);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<Void> deleteMyTaskAsync(int id);

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    Observable<ServiceResponse<Void>> deleteMyTaskWithServiceResponseAsync(int id);

}
