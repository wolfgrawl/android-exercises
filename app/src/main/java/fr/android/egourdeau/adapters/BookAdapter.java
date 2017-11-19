package fr.android.egourdeau.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.android.egourdeau.activities.BookListener;
import fr.android.egourdeau.models.BookView;
import fr.android.egourdeau.R;
import fr.android.egourdeau.models.Book;


/**
 * Created by elie on 16/11/2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {
    private final List<Book> books;
    private final LayoutInflater inflater;
    private final BookListener listener;

    public BookAdapter(LayoutInflater inflater, List<Book> books, BookListener listener) {
        this.books = books;
        this.inflater = inflater;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(this.inflater.inflate(R.layout.book_view, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ((BookView)holder.itemView).bindView(books.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
