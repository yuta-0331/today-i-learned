#include "Deck.h"
#include <iostream>

void hello_world()
{
    std::cout << "hello world!" << std::endl;
}

int main() {
    Deck deck;
    deck.get_deck()[0].put_card();

    std::cout << "hello world" << std::endl;

    hello_world();
    int a = static_cast<int>(1.234f);
    std::cout << a << std::endl;

}

