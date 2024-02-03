//
// Created by 比嘉優太 on 2023/12/02.
//
#include <algorithm>
#include <chrono>
#include <random>
#include "Deck.h"

Deck::Deck(void)
{
    create_one_deck();
    shuffle_deck();
}

Deck::Deck(int deck_set)
{
    for (int i = 0; i < deck_set; i++) {
        create_one_deck();
    }
    shuffle_deck();
}

std::vector<Card> Deck::get_deck()
{
    return deck;
}

void Deck::create_one_deck(void)
{
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 13; j++) {
            deck.push_back(Card{static_cast<Suit>(i), j});
        }
    }
}

void Deck::shuffle_deck(void)
{
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::shuffle(deck.begin(), deck.end(), std::default_random_engine(seed));
}

Card& Deck::hand_out_cards(void)
{
    return deck[deck_top++];
}