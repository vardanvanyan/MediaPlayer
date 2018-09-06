package com.example.vardan.musicplayer;

import java.util.ArrayList;
import java.util.List;

public class MusicProvider {
    public static List<Model> list = new ArrayList<>();

    public static List<Model> getList() {
        list.add(new Model("Charlotte Cardin – Dirty Dirty", R.raw.music, R.drawable.ic_airline_seat_24dp, false));
        list.add(new Model("Charlotte Cardin – Main Girl", R.raw.music1, R.drawable.ic_airline_seat_24dp, false));
        list.add(new Model("Charlotte Cardin – Dirty Dirty", R.raw.music, R.drawable.ic_airline_seat_24dp, false));
        list.add(new Model("Charlotte Cardin – Dirty Dirty", R.raw.music, R.drawable.ic_airline_seat_24dp, false));

        return list;
    }

    public static Model getItemByPosition(int position) {
        return list.get(position);
    }
}
