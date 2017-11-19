package fr.android.egourdeau.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.android.egourdeau.R;
import fr.android.egourdeau.fragments.FragmentDetail;
import fr.android.egourdeau.fragments.FragmentList;
import fr.android.egourdeau.models.Book;
import timber.log.Timber;

/**
 * Created by elie on 16/11/2017.
 */

public class LibraryActivity extends AppCompatActivity implements BookListener {

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Timber.plant(new Timber.DebugTree());

        FragmentList fragmentBookList;

        if(savedInstanceState != null) {
            fragmentBookList = (FragmentList) getSupportFragmentManager().findFragmentByTag(FragmentList.class.getSimpleName());
            book = savedInstanceState.getParcelable("BOOK");
        } else {
            fragmentBookList = new FragmentList();
        }

        displayFragmentBookDetail();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, fragmentBookList, FragmentList.class.getSimpleName())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("BOOK", book);
    }

    @Override
    public void onBookItemClick(Book book) {
        this.book = book;

        Timber.i("clicked on " + book.getTitle());

        displayFragmentBookDetail();
    }

    private void displayFragmentBookDetail() {
        FragmentDetail fragmentDetail = new FragmentDetail();

        Bundle bundle = new Bundle();
        bundle.putParcelable("BOOK", book);
        fragmentDetail.setArguments(bundle);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, fragmentDetail, FragmentDetail.class.getSimpleName())
                    .addToBackStack("FromList")
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.bookDetail, fragmentDetail, FragmentDetail.class.getSimpleName())
                    .commit();
        }

    }

}