/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.jesdin.taskmanager.mytaskapi.implementation;

import com.jesdin.taskmanager.mytaskapi.MyAPI;
import com.microsoft.rest.ServiceClient;
import com.microsoft.rest.RestClient;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.jesdin.taskmanager.mytaskapi.models.MyTask;
import com.microsoft.rest.RestException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * Initializes a new instance of the MyAPI class.
 */
public class MyAPIImpl extends ServiceClient implements MyAPI {
    /**
     * The Retrofit service to perform REST calls.
     */
    private MyAPIService service;

    /**
     * Initializes an instance of MyAPI client.
     */
    public MyAPIImpl() {
        this("https://");
    }

    /**
     * Initializes an instance of MyAPI client.
     *
     * @param baseUrl the base URL of the host
     */
    public MyAPIImpl(String baseUrl) {
        super(baseUrl);
        initialize();
    }

    /**
     * Initializes an instance of MyAPI client.
     *
     * @param clientBuilder the builder for building an OkHttp client, bundled with user configurations
     * @param restBuilder the builder for building an Retrofit client, bundled with user configurations
     */
    public MyAPIImpl(OkHttpClient.Builder clientBuilder, Retrofit.Builder restBuilder) {
        this("https://", clientBuilder, restBuilder);
        initialize();
    }

    /**
     * Initializes an instance of MyAPI client.
     *
     * @param baseUrl the base URL of the host
     * @param clientBuilder the builder for building an OkHttp client, bundled with user configurations
     * @param restBuilder the builder for building an Retrofit client, bundled with user configurations
     */
    public MyAPIImpl(String baseUrl, OkHttpClient.Builder clientBuilder, Retrofit.Builder restBuilder) {
        super(baseUrl, clientBuilder, restBuilder);
        initialize();
    }

    /**
     * Initializes an instance of MyAPI client.
     *
     * @param restClient the REST client containing pre-configured settings
     */
    public MyAPIImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    private void initialize() {
        initializeService();
    }

    private void initializeService() {
        service = retrofit().create(MyAPIService.class);
    }

    /**
     * The interface defining all the services for MyAPI to be
     * used by Retrofit to perform actually REST calls.
     */
    interface MyAPIService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.jesdin.mytaskapi.MyAPI getMyTask" })
        @GET("api/MyTasks")
        Observable<Response<ResponseBody>> getMyTask();

        @Headers({ "Content-Type: application/json-patch+json; charset=utf-8", "x-ms-logging-context: com.jesdin.mytaskapi.MyAPI postMyTask" })
        @POST("api/MyTasks")
        Observable<Response<ResponseBody>> postMyTask(@Body MyTask myTask);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.jesdin.mytaskapi.MyAPI getMyTask1" })
        @GET("api/MyTasks/{id}")
        Observable<Response<ResponseBody>> getMyTask1(@Path("id") int id);

        @Headers({ "Content-Type: application/json-patch+json; charset=utf-8", "x-ms-logging-context: com.jesdin.mytaskapi.MyAPI putMyTask" })
        @PUT("api/MyTasks/{id}")
        Observable<Response<ResponseBody>> putMyTask(@Path("id") int id, @Body MyTask myTask);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.jesdin.mytaskapi.MyAPI deleteMyTask" })
        @HTTP(path = "api/MyTasks/{id}", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> deleteMyTask(@Path("id") int id);

    }

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;MyTask&gt; object if successful.
     */
    public List<MyTask> getMyTask() {
        return getMyTaskWithServiceResponseAsync().toBlocking().single().body();
    }

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<MyTask>> getMyTaskAsync(final ServiceCallback<List<MyTask>> serviceCallback) {
        return ServiceFuture.fromResponse(getMyTaskWithServiceResponseAsync(), serviceCallback);
    }

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MyTask&gt; object
     */
    public Observable<List<MyTask>> getMyTaskAsync() {
        return getMyTaskWithServiceResponseAsync().map(new Func1<ServiceResponse<List<MyTask>>, List<MyTask>>() {
            @Override
            public List<MyTask> call(ServiceResponse<List<MyTask>> response) {
                return response.body();
            }
        });
    }

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MyTask&gt; object
     */
    public Observable<ServiceResponse<List<MyTask>>> getMyTaskWithServiceResponseAsync() {
        return service.getMyTask()
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<MyTask>>>>() {
                @Override
                public Observable<ServiceResponse<List<MyTask>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<List<MyTask>> clientResponse = getMyTaskDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<List<MyTask>> getMyTaskDelegate(Response<ResponseBody> response) throws RestException, IOException {
        return this.restClient().responseBuilderFactory().<List<MyTask>, RestException>newInstance(this.serializerAdapter())
                .register(200, new TypeToken<List<MyTask>>() { }.getType())
                .build(response);
    }

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void postMyTask() {
        postMyTaskWithServiceResponseAsync().toBlocking().single().body();
    }

    /**
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> postMyTaskAsync(final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(postMyTaskWithServiceResponseAsync(), serviceCallback);
    }

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> postMyTaskAsync() {
        return postMyTaskWithServiceResponseAsync().map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> postMyTaskWithServiceResponseAsync() {
        final MyTask myTask = null;
        return service.postMyTask(myTask)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = postMyTaskDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     *
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void postMyTask(MyTask myTask) {
        postMyTaskWithServiceResponseAsync(myTask).toBlocking().single().body();
    }

    /**
     *
     * @param myTask the MyTask value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> postMyTaskAsync(MyTask myTask, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(postMyTaskWithServiceResponseAsync(myTask), serviceCallback);
    }

    /**
     *
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> postMyTaskAsync(MyTask myTask) {
        return postMyTaskWithServiceResponseAsync(myTask).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     *
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> postMyTaskWithServiceResponseAsync(MyTask myTask) {
        Validator.validate(myTask);
        return service.postMyTask(myTask)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = postMyTaskDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> postMyTaskDelegate(Response<ResponseBody> response) throws RestException, IOException {
        return this.restClient().responseBuilderFactory().<Void, RestException>newInstance(this.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void getMyTask1(int id) {
        getMyTask1WithServiceResponseAsync(id).toBlocking().single().body();
    }

    /**
     *
     * @param id the int value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> getMyTask1Async(int id, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(getMyTask1WithServiceResponseAsync(id), serviceCallback);
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> getMyTask1Async(int id) {
        return getMyTask1WithServiceResponseAsync(id).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> getMyTask1WithServiceResponseAsync(int id) {
        return service.getMyTask1(id)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = getMyTask1Delegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> getMyTask1Delegate(Response<ResponseBody> response) throws RestException, IOException {
        return this.restClient().responseBuilderFactory().<Void, RestException>newInstance(this.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void putMyTask(int id) {
        putMyTaskWithServiceResponseAsync(id).toBlocking().single().body();
    }

    /**
     *
     * @param id the int value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> putMyTaskAsync(int id, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(putMyTaskWithServiceResponseAsync(id), serviceCallback);
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> putMyTaskAsync(int id) {
        return putMyTaskWithServiceResponseAsync(id).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> putMyTaskWithServiceResponseAsync(int id) {
        final MyTask myTask = null;
        return service.putMyTask(id, myTask)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = putMyTaskDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void putMyTask(int id, MyTask myTask) {
        putMyTaskWithServiceResponseAsync(id, myTask).toBlocking().single().body();
    }

    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> putMyTaskAsync(int id, MyTask myTask, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(putMyTaskWithServiceResponseAsync(id, myTask), serviceCallback);
    }

    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> putMyTaskAsync(int id, MyTask myTask) {
        return putMyTaskWithServiceResponseAsync(id, myTask).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     *
     * @param id the int value
     * @param myTask the MyTask value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> putMyTaskWithServiceResponseAsync(int id, MyTask myTask) {
        Validator.validate(myTask);
        return service.putMyTask(id, myTask)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = putMyTaskDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> putMyTaskDelegate(Response<ResponseBody> response) throws RestException, IOException {
        return this.restClient().responseBuilderFactory().<Void, RestException>newInstance(this.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws RestException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void deleteMyTask(int id) {
        deleteMyTaskWithServiceResponseAsync(id).toBlocking().single().body();
    }

    /**
     *
     * @param id the int value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> deleteMyTaskAsync(int id, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(deleteMyTaskWithServiceResponseAsync(id), serviceCallback);
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> deleteMyTaskAsync(int id) {
        return deleteMyTaskWithServiceResponseAsync(id).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     *
     * @param id the int value
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> deleteMyTaskWithServiceResponseAsync(int id) {
        return service.deleteMyTask(id)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = deleteMyTaskDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> deleteMyTaskDelegate(Response<ResponseBody> response) throws RestException, IOException {
        return this.restClient().responseBuilderFactory().<Void, RestException>newInstance(this.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}
