import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class ConsumoAPICriptomoedas {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um livro: ");
        var livroBuscado = s.nextLine();

        var endereco = "https://www.googleapis.com/books/v1/volumes?q=" + livroBuscado + "+intitle:" + livroBuscado + "&key=AIzaSyBwgNsFRB0gLUicpIr5ynXP6UNwT37QZmw";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();

        HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());
            
        System.out.println(response.body());
    }
}
