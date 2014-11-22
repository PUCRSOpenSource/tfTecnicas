package tmdbTecnicas;

import com.omertron.themoviedbapi.model.MovieDb;
import java.util.List;

public class TesteTmdbTecnicas {

    public static void main(String[] args) throws FachadaServicoTmdbException {
        FachadaServicoTmdb tmdb = new FachadaServicoTmdb("5a1a77e2eba8984804586122754f969f");
        List<MovieDb> resultado = tmdb.buscarFilmes("Star Wars");
        for (MovieDb filme : resultado) {
            System.out.println(filme.getId());
            System.out.println(filme.getTitle());
            System.out.println(filme.getReleaseDate());
            System.out.println(filme.getPosterPath());
            System.out.println("-----------------");
        }
    }
    
}
