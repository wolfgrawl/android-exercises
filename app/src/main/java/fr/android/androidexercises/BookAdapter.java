package fr.android.androidexercises;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    private final List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.books = books;
        // TODO LayoutInflater.from()
    }

    @Override
    public int getCount() {
        return 0; // TODO
    }

    @Override
    public Book getItem(int position) {
        return null; // TODO
    }

    @Override
    public long getItemId(int position) {
        return 0; // TODO
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null; // TODO
    }

}
