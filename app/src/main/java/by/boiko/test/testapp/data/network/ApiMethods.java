package by.boiko.test.testapp.data.network;


import by.boiko.test.testapp.data.ResponseModel.DailyExRates;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiMethods {

    @GET("XmlExRates.aspx")
    Observable<Response<DailyExRates>> getInfo();
}
