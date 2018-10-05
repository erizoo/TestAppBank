package by.boiko.test.testapp.data.network;

import by.boiko.test.testapp.data.ResponseModel.DailyExRates;
import io.reactivex.Observable;
import retrofit2.Response;

public interface ServiceNetwork {

    Observable<Response<DailyExRates>> getInfo();
}
