package com.pratik.cardlistdemo;


import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int listImages[] = new int[]{R.drawable.logo_apple, R.drawable.logo_shell,
                R.drawable.logo_volkswagen, R.drawable.logo_ea};

        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i<4; i++) {
            // Create a Card
            Card card = new Card(this);
            // Create a CardHeader
            CardHeader header = new CardHeader(this);
            // Add Header to card
            header.setTitle("Logo : " + i);
            card.setTitle("Set Your Text Here");
            card.addCardHeader(header);

            CardThumbnail thumb = new CardThumbnail(this);
            thumb.setDrawableResource(listImages[i]);
            card.addCardThumbnail(thumb);
            cards.add(card);
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);
        CardListView listView = (CardListView) this.findViewById(R.id.cardListView);
        if (listView != null) {
            listView.setAdapter(mCardArrayAdapter);
        }
    }
}