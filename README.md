# JumpyMonkey
Simple game using threading 
Jumpy Monkey Rules
Baby Monkey is restless before bed and needs to burn off some energy before
falling asleep. Baby Monkey needs to jump on the bed until he is tired. Mommy
Monkey comes in randomly to check in on Baby Monkey.
1. Press ‘Start’ to play the game. Pressing ‘Start’starts a new game even if
there’s one in progress.
2. Press the space bar to make Baby Monkey jump. When he jumps he gains
points and that progress shows on the bar to the top right of the window.
3. If Baby Monkey jumps when Mommy Monkey is in the room (y=400) then
the game is lost.
4. If Baby Monkey manages to fill the bar (150 points) without being caught by
Mommy Monkey, then the game is won.
Notes:
1. Repeated pressing of the space bar makes Baby Monkey jump each time the
space bar has been pressed. Eg. If you press the space bar really quickly,
Baby Monkey will jump as many times as the space bar has been pressed
and if Mommy Monkey enters the room while Baby Monkey is jumping,
you will be caught and lose the game.
2. When pausing the game, if Mommy Monkey is still in the room, the thread
is still executing and she will leave. No progress will occur.
