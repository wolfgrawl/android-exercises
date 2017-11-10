package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Retrofit;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        Retrofiit retrofit = new Retrofit.Builder().baseUrl("http://henri-potier.xebia.fr/").addConverterFactory(GsonConverterFactory.create()).build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);

        // TODO build Retrofit

        // TODO create a service

        // TODO listBooks()

        // TODO enqueue call and display book title

        // TODO log books

        // TODO display book as a list
    }

}
