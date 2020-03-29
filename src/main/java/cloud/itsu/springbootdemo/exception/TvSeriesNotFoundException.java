package cloud.itsu.springbootdemo.exception;

public class TvSeriesNotFoundException extends RuntimeException {

    public TvSeriesNotFoundException(int id) {
        super("The id " + id + " could not be found");
    }
}
