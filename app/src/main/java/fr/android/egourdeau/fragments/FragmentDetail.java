package fr.android.egourdeau.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import fr.android.egourdeau.R;
import fr.android.egourdeau.models.Book;

/**
 * Created by elie on 16/11/2017.
 */

public class FragmentDetail extends Fragment {

    private Book book;
    private ImageView coverDetail;
    private TextView descriptionDetail;
    private TextView isbnDetail;
    private TextView priceDetail;
    private TextView titleDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup    container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        book = (Book) this.getArguments().getParcelable("BOOK");

        this.coverDetail = view.findViewById(R.id.coverDetailView);
        this.descriptionDetail = view.findViewById(R.id.descriptionDetailView);
        this.isbnDetail = view.findViewById(R.id.isbnDetailVview);
        this.priceDetail = view.findViewById(R.id.priceDetailView);
        this.titleDetail = view.findViewById(R.id.titleDetailView);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(book != null) {
            StringBuilder sb = new StringBuilder();

            for(String s: book.getSynopsis()) {
                sb.append(s + "\n");
            }

            titleDetail.setText(book.getTitle());
            isbnDetail.setText("isbn : " + book.getIsbn());
            priceDetail.setText("Price : " + book.getPrice() + "€");
            descriptionDetail.setText(sb.toString());

            Glide.with(view.getContext())
                    .load(book.getCover())
                    .into(coverDetail);
        }
        else {
            titleDetail.setText("Select a book");
            isbnDetail.setText("");
            priceDetail.setText("");
            descriptionDetail.setText("");
            coverDetail.setImageResource(0);
        }
    }

}