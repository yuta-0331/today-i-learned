cmake_minimum_required(VERSION 3.26)
project(clang C)

set(CMAKE_C_STANDARD 11)

add_executable(clang
        lesson01/hello.c
        lesson01/sort.c
        lesson01/struct.c
        switchStatement/ExSwitch01.c
        switchStatement/ExSwitch02.c
        switchStatement/ExSwitch03.c)
