import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;

public class BitcoinPriceChecker {

    private static final String API_URL = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";

    public static double getBitconPrice(){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            String strRes = response.body().string();
            Gson gson = new Gson();
            BitcoinPriceResponse mapedResponse = gson.fromJson(strRes, BitcoinPriceResponse.class);
            return mapedResponse.getBitcoin().getUsd();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
