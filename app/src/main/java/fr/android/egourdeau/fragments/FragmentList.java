package fr.android.egourdeau.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.android.egourdeau.adapters.BookAdapter;
import fr.android.egourdeau.activities.BookListener;
import fr.android.egourdeau.services.BookService;
import fr.android.egourdeau.R;
import fr.android.egourdeau.models.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by elie on 16/11/2017.
 */

public class FragmentList extends Fragment {
    private BookListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (BookListener)context;
    }

    @Nullable
    @Override
    public View onCreateView(final  LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookService service = retrofit.create(BookService.class);

        Call<List<Book>> listCall = service.listBooks();

        listCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> books = response.body();

                for(Book b: books) {
                    Timber.d(b.getTitle());
                }

                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bookListView);
                recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),1));
                recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(new BookAdapter(LayoutInflater.from(view.getContext()), books, listener));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.e(t);
            }
        });
    }
}