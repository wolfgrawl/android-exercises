package fr.android.egourdeau.activities;

import fr.android.egourdeau.models.Book;

/**
 * Created by elie on 16/11/2017.
 */

public interface BookListener {
    void onBookItemClick(Book book);
}