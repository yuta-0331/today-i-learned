//
// Created by 比嘉優太 on 2023/12/02.
//

#ifndef CARD_GAME_CARD_H
#define CARD_GAME_CARD_H
#include "Suit.h"
#include <iostream>
#include <string>
#include <vector>

class Card
{
    Suit suit;
    int num;
public:
    // constructor
    Card(Suit suit, int num): suit{suit}, num{num} {}
    // getter
    Suit get_suit(void)
    {
        return suit;
    }
    int get_num(void)
    {
        return num;
    }

    void put_card(void)
    {
        std::vector<std::string> suit_name = {
                "SPADE", "HEART", "DIAMOND", "CLOVER",
        };
        std::string num_str;
        switch (num) {
            case 1:
                num_str = "A";
                break;
            case 11:
                num_str = "J";
                break;
            case 12:
                num_str = "Q";
                break;
            case 13:
                num_str = "K";
                break;
            default:
                num_str = std::to_string(num);
        }
        std::cout
                << "["
                << suit_name[static_cast<int>(suit)]
                << " "
                << num_str
                << "]"
                << std::endl;
    }
};

#endif //CARD_GAME_CARD_H
