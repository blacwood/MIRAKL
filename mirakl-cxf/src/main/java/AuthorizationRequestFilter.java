import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Manu on 1/30/2017.
 */
@Provider
public class AuthorizationRequestFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        String apiKey = (String) requestContext.getProperty(HttpHeaders.AUTHORIZATION);
        if(apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("No API Key found");
        }
        requestContext.getHeaders().putSingle(HttpHeaders.AUTHORIZATION, apiKey);
    }
}
