package by.boiko.test.testapp.ui;

import by.boiko.test.testapp.data.ResponseModel.DailyExRates;
import by.boiko.test.testapp.ui.base.MvpView;
import io.reactivex.Observable;
import retrofit2.Response;

public interface MainMvpView extends MvpView {

    void onInfoGeted(Response<DailyExRates> dailyExRates);
}
