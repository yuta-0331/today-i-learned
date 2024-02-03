//
// Created by 比嘉優太 on 2023/12/02.
//
#ifndef CARD_GAME_DECK_H
#define CARD_GAME_DECK_H

#include <string>
#include <vector>
#include "Card.h"

class Deck
{
    std::vector<Card> deck;
    int deck_top = 0;
public:
    // constructor
    explicit Deck(void);
    explicit Deck(int deck_set);
    // getter
    std::vector<Card> get_deck(void );

    void create_one_deck(void);
    void shuffle_deck(void);
    Card& hand_out_cards(void);
};

#endif //CARD_GAME_DECK_H
