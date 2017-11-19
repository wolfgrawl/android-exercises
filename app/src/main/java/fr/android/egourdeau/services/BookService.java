package fr.android.egourdeau.services;


import java.util.List;

import fr.android.egourdeau.models.Book;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by elie on 16/11/2017.
 */

public interface BookService {
    @GET("books")
    Call<List<Book>> listBooks();
}