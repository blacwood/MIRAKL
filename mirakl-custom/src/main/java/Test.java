import com.bigname.core.restful.client.security.Credential;
import com.bigname.marketplace.mirakl.client.MiraklApiClient;

import java.io.IOException;

/**
 * Created by Manu on 2/7/2017.
 */
public class Test {
    public static final String FRONT_API_KEY = "5e5905d3-8a11-4b6b-bce9-c37f7a0111d5";
    public static final String ENV_URL = "https://envelopes-dev.mirakl.net/api";

    public static void main(String[] args) throws IOException{
        MiraklApiClient client = new MiraklApiClient(ENV_URL, new Credential(FRONT_API_KEY));
        System.out.println(client.getVersion().getVersion());
    }
}
