package tmdbTecnicas;

public class FachadaServicoTmdbException extends Exception{

    public FachadaServicoTmdbException() {
    }

    public FachadaServicoTmdbException(String message) {
        super(message);
    }

    public FachadaServicoTmdbException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
