<!-- Create an index in .md format by which when users click some topic it redirects/scrolls to bottom to the heading -->

# Puzzles
## Index

- [Puzzles](#puzzles)
  - [Index](#index)
- [Question 1. Airplane Seating Puzzle](#question-1-airplane-seating-puzzle)
  - [Solution](#solution)
    - [Logical Reasoning](#logical-reasoning)
    - [Mathematical Verification](#mathematical-verification)


# Question 1. Airplane Seating Puzzle

100 passengers board an airplane with exactly 100 seats. Everyone has a ticket with an assigned seat number. However, the first passenger has lost their ticket and takes a random seat. Every subsequent passenger attempts to choose their own seat, but takes a random seat if their's is taken.

Suppose you are the very last passenger to board the plane. What is the probability that you will get your assigned seat?

## Solution

### Logical Reasoning 

Now, let's consider any passenger who is forced to choose a seat at random (this could be the first passenger or any later passenger whose seat was taken). When they look at the available empty seats, they will see a set of options.

Crucially, as long as the chain reaction is still going, both **Seat #1** and **Seat #100** *must* be available.

From this passenger's point of view, $S_1$ and $S_{100}$ are just two of the empty seats. Since their choice is random, there is no reason to prefer one over the other. Therefore, at the moment of choice:

**The probability of choosing Seat #1 is exactly the same as the probability of choosing Seat #100.**

Since the entire process must end with one of these two seats being chosen, and at every step the choice between them is equally likely, the overall probability is split evenly between the two outcomes.

* The probability that the chain ends with $S_1$ being taken is $1/2$. (You win 🏆)
* The probability that the chain ends with $S_{100}$ being taken is $1/2$. (You lose 😔)

Therefore, the probability that you get your assigned seat is **1/2**.

***

### Mathematical Verification

To make it concrete, let's try it with just 3 passengers ($P_1, P_2, P_3$). What is the probability $P_3$ gets their seat ($S_3$)?

1.  **$P_1$ chooses a seat (out of $S_1, S_2, S_3$):**
    * **Case 1: $P_1$ chooses $S_1$ (Probability 1/3).**
        The cycle ends. $P_2$ takes $S_2$, and $P_3$ gets their seat, $S_3$. **($P_3$ Wins)**
    * **Case 2: $P_1$ chooses $S_3$ (Probability 1/3).**
        $P_3$'s seat is taken. **($P_3$ Loses)**
    * **Case 3: $P_1$ chooses $S_2$ (Probability 1/3).**
        Now, $P_2$ comes to board and finds $S_2$ is taken. $P_2$ must choose randomly from the remaining seats: $S_1$ and $S_3$.
        * $P_2$ chooses $S_1$ (Probability 1/2). The cycle ends. $P_3$ boards and finds $S_3$ is free. **($P_3$ Wins)**
        * $P_2$ chooses $S_3$ (Probability 1/2). $P_3$'s seat is taken. **($P_3$ Loses)**

Let's calculate the total probability of $P_3$ winning:
* From Case 1: $1/3$
* From Case 3: $(1/3) \times (1/2) = 1/6$

Total Probability = $1/3 + 1/6 = 2/6 + 1/6 = 3/6 = \mathbf{1/2}$.

This confirms the logic holds true, regardless of the number of passengers. ✈️

