import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Manu on 2/7/2017.
 */
public class MiraklCXF {
    public static void main(String[] args) {
        Client client = ClientBuilder.newBuilder().newClient();
        client.register(new AuthorizationRequestFilter()).register(new JacksonJsonProvider())/*.register(new DefaultAcceptRequestFilter())*/;
        WebTarget target = client.target("https://envelopes-dev.mirakl.net/api");
        target = target.path("version");

        Invocation.Builder builder = target.request();
        builder.property(HttpHeaders.AUTHORIZATION, "5e5905d3-8a11-4b6b-bce9-c37f7a0111d5");
        builder.accept(MediaType.APPLICATION_JSON_TYPE);
        Response response = builder.get();


    }
}
