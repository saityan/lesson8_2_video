package ru.geekbrains.lesson8_2_video.model;

import ru.geekbrains.lesson8_2_video.model.domain.CardData;

public interface CardSource {
    int size ();
    CardData getCardData(int position);
}
