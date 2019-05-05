package forecast.weather.com.weatherforecast;

import android.content.Context;
import android.content.SharedPreferences;

import com.weather.forecast.model.WeatherMainData;
import com.weather.forecast.presenter.WeatherPresenter;
import com.weather.forecast.util.Utility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */

@RunWith(MockitoJUnitRunner.class)
public class WeatherPresenterTest {

    @Test
    public void shouldSaveDataInPreference(){
        Context context = mock(Context.class);
        SharedPreferences sharedPreferences = mock(SharedPreferences.class);
        Utility.saveLUT(sharedPreferences,2000);
        long time = Utility.getLUT(sharedPreferences);
        assertEquals(time,20);
    }

    @Test
    public void prepareDataForUITest(){
        ArrayList<WeatherMainData> arrayListWeatherMainData = new ArrayList<>();
        WeatherPresenter weatherPresenter = mock(WeatherPresenter.class);
        ArrayList<WeatherMainData> alWeatherMainData = weatherPresenter.prepareDataForUI(arrayListWeatherMainData);
        assertEquals(alWeatherMainData.size(),arrayListWeatherMainData.size());
    }
}
