//
// Created by 比嘉優太 on 2023/12/12.
//

#ifndef CARD_GAME_BASE_PLAYER_H
#define CARD_GAME_BASE_PLAYER_H

#include <string>
#include <vector>
#include "Card.h"

class BasePlayer
{
    std::string name;
    int coins;
    int bet_coins = 0;
    std::vector<Card> hand_cards;

public:
    BasePlayer(std::string name, int coins)
        : name{name}, coins{coins} {}
    void bet(int bet_coins);
};


#endif //CARD_GAME_BASE_PLAYER_H
