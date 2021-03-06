import com.google.gson.Gson;
import movhub.MovService;
import movhub.data.MovhubWebApi;
import movhub.model.MovieDetails;
import util.HttpRequest;
import util.IRequest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;


/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Gson gson = new Gson();
        String uri = "https://api.themoviedb.org/3/search/movie?query=Deadpool&api_key=629fc6979bdef5c207d398578144c126";
        String ur2 = "https://api.themoviedb.org/3/movie/293660?api_key=629fc6979bdef5c207d398578144c126";
        String uri3 = "https://api.themoviedb.org/3/movie/293660/credits?api_key=629fc6979bdef5c207d398578144c126";
        String uri4 = "https://api.themoviedb.org/3/person/10859/movie_credits?api_key=629fc6979bdef5c207d398578144c126";
//        IRequest req = new HttpRequest();
//        Iterable<String> body = req.getContent(uri);
//
//      //  body.forEach(System.out::println);
//        String json = join(body);
//        System.out.println("\n\n\nJSON:\n" + json+"\n\n");
//
//        MovieSearchDto  dto = gson.fromJson(json, MovieSearchDto.class);
////        ActorCreditsDto dto1 = gson.fromJson(json, ActorCreditsDto.class);
//        MovieDetailsDto movieDetailsDto = gson.fromJson(json, MovieDetailsDto.class);
//        System.out.println("\n\n" + dto
//                +"\n\nMovieDetailsDto:\n"+ movieDetailsDto);



//        Library lib = new Library();
//        if(lib.someLibraryMethod())
//            System.out.println(new App().getGreeting());
//
        IRequest req = new HttpRequest();
//        IRequest req = new FileRequest();
        MovhubWebApi movhubWebApi = new MovhubWebApi(req);
//        movhubWebApi.searchMovie();
        movhubWebApi.searchMovie2(293660);


        MovService movService = new MovService();
        CompletableFuture<Stream<MovieDetails>> m = movService.movieDetails(293660);

        System.out.println("kkkkkkkk "+m.get().map(mm -> mm.getOriginalTitle().toString()));
    }
}
