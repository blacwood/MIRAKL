/**
 * Created by Manu on 1/30/2017.
 */
public enum MiraklEndpoint implements ApiEndpoint{
    V01("version"),

    S20("shops");



    private final String[] paths;

    MiraklEndpoint(String... paths) {
        this.paths = paths;
    }
    @Override
    public String[] getPaths() {
        return paths;
    }
}
