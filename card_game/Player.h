//
// Created by 比嘉優太 on 2023/12/12.
//

#ifndef CARD_GAME_PLAYER_H
#define CARD_GAME_PLAYER_H

#include <vector>
#include "BasePlayer.h"
#include "Card.h"

namespace black_jack {

    class Player : BasePlayer
    {
        int hand_score;

    public:
        void check_hand_score(void);
    };

} // black_jack

namespace poker {

    class Player : BasePlayer
    {

    };
} // poker

#endif //CARD_GAME_PLAYER_H
