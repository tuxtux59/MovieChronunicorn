package com.tiboreno.android.moviechronunicorn;

import android.content.Context;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class OmdbAPI {
    private static OmdbAPI mSigleton;
    private Context mContext;
    public ServiceApi mClient;


    public OmdbAPI(Context context){
        if(mSigleton != null){
            return;
        }
        mContext = context;
        this.setRequestInterceptor();
    }

    private void setRequestInterceptor() {
        try{
            RequestInterceptor mRequestInterceptor = new RequestInterceptor(){

                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/json;version=1");
                }
            };
            String baseUrl = Constant.BASE_URL;
            RestAdapter mAdapter = new RestAdapter.Builder()
                    .setEndpoint(baseUrl)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setRequestInterceptor(mRequestInterceptor)
                    .build();
            mClient = mAdapter.create(ServiceApi.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static OmdbAPI getDefault(Context context){
        if(mSigleton == null){
            mSigleton = new OmdbAPI(context);
        }
        return mSigleton;
    }

    public interface ServiceApi {
        @GET(Constant.API_KEY_PATH)
        void getItemByTItle(@Query("t") String title,
                            Callback<OmdbItem> callback);

    }

}
