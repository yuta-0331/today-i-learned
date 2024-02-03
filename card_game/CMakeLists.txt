cmake_minimum_required(VERSION 3.26)
project(card_game)

set(CMAKE_CXX_STANDARD 17)

add_executable(card_game main.cpp
        Card.h
        Deck.cpp
        Deck.h
        Suit.h
        Player.cpp
        Player.h
        BasePlayer.cpp
        BasePlayer.h)
