"""
=======================
**Project gawibawibo**
=======================
-----------------------
WooJin_Jo 2016.10.16
-----------------------
"""

import random
win = 0
draw = 0
lose = 0
"""1. import random
    Will use for computer random
2. extra parameter
    win : count win
    draw : count draw
    lose : count lose
"""


def playthegame():
    loop()
    result_print()
    
def loop():
    """1. first while
        Limit Games Played to 10 times, player select gawi(1) or bawi(2) or bo(3)
    2. secound while
        Receive to re-enter when the wrong input came in
    """
    play = 0
    global player
    while play < 10:
        #player_choice
        select = input("Enter your choice (gawi = 1 / bawi = 2 / bo = 3): ")
        player = int(select)
        if(player == 1):
            print("gawi")
        elif(player == 2):
            print("bawi")
        elif(player == 3):
            print("bo")
        play += 1
        while (player != 1 and player != 2 and player != 3):
            select = input("Enter your choice (gawi = 1 / bawi = 2 / bo = 3): ")
            player = int(select)
        computer_random()
        decision()
    


    
def computer_random():
    """Select randomly computer's gawi or bawi or bo
    """
    global computer
    computer = random.randint(1,3)
    if (computer == 1):
        computer = 1
    elif (computer == 2):
        computer = 2
    elif (computer == 3):
        computer = 3
    else:
        print ("Error. Enter your choice from gawi, bawi, bo.")


def decision():
    """Show computer's gawi or bawi or bo and player's gawi, bawi, bo decision win, draw, lose depending on the situation
    Depending on the result win or draw or lose +1
    """
    global win
    global draw
    global lose
    if(player == computer):
        if (player == 1):
            print("computer is gawi")
        elif (player == 2):
            print("computer is bawi")
        elif (player == 3):
            print("computer is bo")
        print ("Draw!")
        draw += 1
    elif (player == 1):
        if (computer == 2):
            print("computer is gawi")
            print ("You lost.")
            lose += 1
        if (computer == 3):
            print("computer is bo")
            print("You won.")
            win += 1
    elif (player == 2):
        if (computer == 1):
            print("computer is gawi")
            print ("You won.")
            win += 1
        if (computer == 3):
            print("computer is bo")
            print ("You lost.")
            lose += 1
    elif (player == 3):
        if (computer == 1):
            print("computer is gawi")
            print ("You lost.")
            lose += 1
        if (computer == 2):
            print("computer is bawi")
            print ("You won.")
            win +=1
    

def result_print():
    """10times game result print by win, draw, lose"""
    print("game result :", win, "win", draw, "draw", lose, "lose")

