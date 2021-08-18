package ru.geekbrains.lesson8_2_video;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class CardSourceImplementation implements CardSource {

    private List<CardData> dataSource;
    private Resources resources;

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

    public CardSourceImplementation (Resources resources) {
        this.resources = resources;
    }

    public CardSourceImplementation init() {
        dataSource = new ArrayList<>();
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        TypedArray picturesArray = resources.obtainTypedArray(R.array.pictures);
        int[] pictures = new int[picturesArray.length()];
        for(int i = 0; i < picturesArray.length(); i++) {
            pictures[i] = picturesArray.getResourceId(i, -1);
        }

        for (int i = 0; i < titles.length; i++) {
            dataSource.add(new CardData(titles[i], descriptions[i], pictures[i], false));
        }

        return this;
    }
}
