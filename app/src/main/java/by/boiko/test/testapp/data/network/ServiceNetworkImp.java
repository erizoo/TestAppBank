package by.boiko.test.testapp.data.network;

import javax.inject.Inject;

import by.boiko.test.testapp.data.ResponseModel.DailyExRates;
import io.reactivex.Observable;
import retrofit2.Response;

public class ServiceNetworkImp implements ServiceNetwork {

    private static final String TAG = ServiceNetworkImp.class.getSimpleName();

    private ApiMethods apiMethods;

    @Inject
    public ServiceNetworkImp(ApiMethods apiMethods) {
        this.apiMethods = apiMethods;
    }

    @Override
    public Observable<Response<DailyExRates>> getInfo() {
        return apiMethods.getInfo();
    }
}
