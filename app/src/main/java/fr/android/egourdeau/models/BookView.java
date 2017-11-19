package fr.android.egourdeau.models;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import fr.android.egourdeau.R;
import fr.android.egourdeau.activities.BookListener;


/**
 * Created by elie on 16/11/2017.
 */


public class BookView extends LinearLayout {
    private TextView bookTitle;
    private TextView bookPrice;
    private ImageView bookCover;

    public BookView(Context context) {
        this(context, null);
    }

    public BookView(Context context, AttributeSet attributes) {
        this(context, attributes, 0);
    }

    public BookView(Context context, AttributeSet attributes, int defStyleAttr) {
        super(context, attributes, defStyleAttr);
    }

    public void bindView(final Book book, final BookListener listener) {
        bookTitle.setText(book.getTitle());
        bookPrice.setText(book.getPrice() + "€");
        Glide.with(this).load(book.getCover()).into(bookCover);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onBookItemClick(book);
            }
        });
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.bookTitle = findViewById(R.id.bookTitle);
        this.bookPrice = findViewById(R.id.bookPrice);
        this.bookCover = findViewById(R.id.bookCover);
    }

}
