package com.lehoaian.core;

import android.content.Context;
import android.util.Log;
import com.lehoaian.hotel.R;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: LETHANHH
 * Date: 6/7/12
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class CitiesApi {
    Context _context;
    String _apiUrl;
    final static String TAG = "API";

    public CitiesApi(Context context){
        this._context = context;
        _apiUrl = context.getString(R.string.api_json_all_cities);
    }

    public JSONObject getResponse(){
        try {
            ApiHelper.prepareUserAgent(_context);
            Log.i(TAG, _apiUrl);
            String response = ApiHelper.getUrlContent(_apiUrl);
            Log.i(TAG, response);
        } catch (ApiHelper.ApiException e) {
            Log.e(TAG, e.getMessage());
        }

        return new JSONObject();
    }

    public String[][] getListOfCities(int refreshFlg){
        return new String[][]{};
    }
}
