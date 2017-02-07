import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Manu on 1/30/2017.
 */
@Provider
public class DefaultAcceptRequestFilter implements ClientRequestFilter {
        private static final Logger LOGGER = Logger.getLogger(DefaultAcceptRequestFilter.class.getName());

        @Override
        public void filter(ClientRequestContext requestContext) throws IOException {
            if (requestContext.getAcceptableMediaTypes().size() == 1) {
                MediaType mediaType = requestContext.getAcceptableMediaTypes().get(0);
                if (mediaType.equals(MediaType.WILDCARD_TYPE)) {
                    LOGGER.fine("Using '" + MediaType.APPLICATION_JSON + "' as acceptable media type");
                    requestContext.getHeaders().putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_TYPE);
                }
            }
        }
}
