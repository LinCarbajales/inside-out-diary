package dev.lin.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class MovieAPI {
    
    private static final String API_URL = "https://imdb.iamidiotareyoutoo.com/search?tt=";

    /**
     * Obtiene los datos de una película de la API usando su ID de IMDb.
     *
     * @param imdbId El ID de la película (ej. "tt2250912").
     * @return Un String que contiene la respuesta JSON de la API si la llamada fue exitosa.
     * Retorna un Optional vacío si hubo un error.
     */
    public Optional<String> getMovieDataByImdbId(String imdbId) {
        
        String fullUrl = API_URL + imdbId;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return Optional.of(response.body());
            } else {
                // Manejo de errores: si el código de estado no es 200 (OK).
                System.err.println("Error al acceder a la API. Código de estado: " + response.statusCode());
                return Optional.empty();
            }
        } catch (IOException | InterruptedException e) {
            // Manejo de excepciones: si ocurre un error de conexión o de interrupción.
            System.err.println("Error de conexión con la API: " + e.getMessage());
            e.printStackTrace();
            return Optional.empty();
        }
    }
}