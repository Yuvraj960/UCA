# Puzzles
## Index

- [Puzzles](#puzzles)
  - [Index](#index)
- [Question 1. Airplane Seating Puzzle](#question-1-airplane-seating-puzzle)
  - [Solution](#solution)
    - [Logical Reasoning](#logical-reasoning)
    - [Mathematical Verification](#mathematical-verification)
- [Question 2. 100 Doors Puzzle](#question-2-100-doors-puzzle)
  - [Solution](#solution-1)
    - [The Rule: Who Toggles Which Door?](#the-rule-who-toggles-which-door)
    - [The Math: Perfect Squares are Oddballs](#the-math-perfect-squares-are-oddballs)
    - [The Final Count](#the-final-count)
- [Question 3. Black and White Caps](#question-3-black-and-white-caps)
    - [The Solution: The Parity Strategy](#the-solution-the-parity-strategy)
    - [The Strategy (Agreed upon in the dark room)](#the-strategy-agreed-upon-in-the-dark-room)
    - [How an Individual Decides](#how-an-individual-decides)
    - [Why This Strategy Always Works](#why-this-strategy-always-works)
- [Question 4. Top 3 of 25 Horses](#question-4-top-3-of-25-horses)
  - [Step-by-Step Solution](#step-by-step-solution)
    - [Step 1: Initial Group Races (5 Races)](#step-1-initial-group-races-5-races)
    - [Step 2: The Winners' Race (1 Race)](#step-2-the-winners-race-1-race)
    - [Step 3: The Final Race for 2nd and 3rd (1 Race)](#step-3-the-final-race-for-2nd-and-3rd-1-race)
  - [Summary of Races](#summary-of-races)


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


# Question 2. 100 Doors Puzzle

There are 100 closed doors, numbered 1 to 100.
100 people walk past the doors one after another:
- Person 1 toggles (opens if closed, closes if open) every door.
- Person 2 toggles every 2nd door (doors 2, 4, 6, ... ).
- Person 3 toggles every 3rd door (doors 3, 6, 9, ... ).
-
-
- Person 100 toggles every 100th door (only door 100).

All doors start closed.

After all 100 people have passed, which doors remain open, and how many of them are open?


The doors that remain open are those with numbers that are **perfect squares**. There will be **10** open doors.

Here’s the step-by-step solution to this classic puzzle. 💡

***

## Solution

The final state of any door depends entirely on **how many times it was toggled**.
* All doors start closed.
* Toggled once: Closed → **Open**
* Toggled twice: Open → **Closed**
* Toggled three times: Closed → **Open**

A door will be left open only if it is toggled an **odd number of times**.

***

### The Rule: Who Toggles Which Door?

The number of times a specific door is toggled is determined by the puzzle's rule: "Person `n` toggles every `n`-th door."

Let's rephrase this from a door's perspective: Door #`D` is toggled by Person #`P` only if `D` is a multiple of `P`. This is the same as saying `P` must be a **factor** (or divisor) of `D`.

Therefore, the total number of times a door is toggled is equal to the **total number of factors** its number has.

Combining these insights: **A door will remain open only if its number has an odd number of factors.**

***

### The Math: Perfect Squares are Oddballs

So, which numbers have an odd number of factors? Let's look at a few.

* **Factors of 10:** 1, 10, 2, 5 (4 factors - an even number)
* **Factors of 12:** 1, 12, 2, 6, 3, 4 (6 factors - an even number)

Factors usually come in pairs. For the number 12, the pairs are (1, 12), (2, 6), and (3, 4). This pairing system almost always results in an even number of factors.

The only way a number can have an odd number of factors is if one of the pairs is not a pair at all, but a single number repeated. This happens when the number is a **perfect square**.

* **Factors of 9 (which is $3^2$):** 1, 9, **3** (3 factors - an odd number). The "pair" for 3 would be $9/3 = 3$, so it's only counted once.
* **Factors of 16 (which is $4^2$):** 1, 16, 2, 8, **4** (5 factors - an odd number).

So, the doors that remain open are those whose numbers are perfect squares. ✅

***

### The Final Count

We just need to find all the perfect squares between 1 and 100.
1.  $1^2 = \mathbf{1}$
2.  $2^2 = \mathbf{4}$
3.  $3^2 = \mathbf{9}$
4.  $4^2 = \mathbf{16}$
5.  $5^2 = \mathbf{25}$
6.  $6^2 = \mathbf{36}$
7.  $7^2 = \mathbf{49}$
8.  $8^2 = \mathbf{64}$
9.  $9^2 = \mathbf{81}$
10. $10^2 = \mathbf{100}$

In total, there are **10 doors** that will remain open. 🚪


# Question 3. Black and White Caps

A group of $N$ people is in a room. They can strategize before the test begins. Each person will be assigned a black or white cap at random. They cannot see their own cap, but they can see the caps of all $N-1$ other people. After the caps are on and they are in a lit room, they cannot communicate in any way. Their goal is to simultaneously move to different sides of the room to form two distinct groups: one of all black-capped people and one of all white-capped people.

---

### The Solution: The Parity Strategy

The solution hinges on the group making a shared, arbitrary assumption **beforehand**. The most common and effective strategy is based on **parity** (whether a number is odd or even).

### The Strategy (Agreed upon in the dark room)

The group must agree on two things:

1.  **Designated Sides:** They designate one side of the room for the "Black Caps" group and the opposite side for the "White Caps" group.
2.  **The Core Assumption:** Everyone agrees to act based on the following shared assumption: **"The total number of black caps in the entire room is an ODD number."**

This assumption might be false in reality, but that doesn't matter, as long as everyone uses it for their logic.

---

### How an Individual Decides

Once they are in the lit room, each person counts the number of black caps they can see on everyone else. Let's say you are one of the people in the room.

* **Scenario A: You see an EVEN number of black caps.**
    * Your Logic: "I see an even number of black caps. Our group's assumption is that the total number of black caps is **odd**. If my own cap were white, the total number of black caps would remain even, which contradicts our assumption. Therefore, my cap **must be black** to make the total odd."
    * Your Action: You walk to the designated "Black Caps" side of the room.

* **Scenario B: You see an ODD number of black caps.**
    * Your Logic: "I see an odd number of black caps. Our group's assumption is that the total number of black caps is **odd**. If my own cap were black, the total would become even, contradicting our assumption. Therefore, my cap **must be white** to keep the total odd."
    * Your Action: You walk to the designated "White Caps" side of the room.

Since every person follows this exact same logic, they can all make a decision and move simultaneously.



---

### Why This Strategy Always Works

This is the brilliant part of the puzzle. The strategy works perfectly regardless of whether the actual number of black caps is odd or even.

* **Case 1: The actual number of black caps IS odd.**
    * A person wearing a **black cap** will see an even number of other black caps. Following the logic, they correctly deduce they are wearing black and go to the "black" side.
    * A person wearing a **white cap** will see an odd number of other black caps. Following the logic, they correctly deduce they are wearing white and go to the "white" side.
    * **Result:** Perfect segregation. Everyone goes to the correct side. ✅

* **Case 2: The actual number of black caps IS even.**
    * A person wearing a **black cap** will see an odd number of other black caps. Following the logic, they will *incorrectly* deduce they are wearing white and go to the "white" side.
    * A person wearing a **white cap** will see an even number of other black caps. Following the logic, they will *incorrectly* deduce they are wearing black and go to the "black" side.
    * **Result:** Every single person goes to the *opposite* side of where they should be. The black-capped people all gather on the "white" side, and the white-capped people all gather on the "black" side. This is still a **perfect segregation** into two pure-colored groups! ✅


# Question 4. Top 3 of 25 Horses

At a race track consisting of 5 tracks, 25 horses are to compete. At a time only 5 can take part. How many races required to find the 1st best, 2nd best, 3rd best horse.


## Step-by-Step Solution

Here's the most efficient method to find the top three horses.

### Step 1: Initial Group Races (5 Races)
First, you need to get a baseline ranking for all 25 horses. Divide the horses into 5 groups (A, B, C, D, E) of 5 horses each and race them.

* **Race 1:** Group A -> Winners are A1 > A2 > A3 > A4 > A5
* **Race 2:** Group B -> Winners are B1 > B2 > B3 > B4 > B5
* **Race 3:** Group C -> Winners are C1 > C2 > C3 > C4 > C5
* **Race 4:** Group D -> Winners are D1 > D2 > D3 > D4 > D5
* **Race 5:** Group E -> Winners are E1 > E2 > E3 > E4 > E5

After these 5 races, we have identified the fastest horse within each group.

***

### Step 2: The Winners' Race (1 Race)
Now, take the winner from each of the first 5 races (A1, B1, C1, D1, E1) and race them against each other. This will be our **6th race**.

Let's assume the result of this race is: **A1 > B1 > C1 > D1 > E1**.



From this single race, we can make a huge deduction:
* **The 1st Fastest Horse:** The winner of this race, **A1**, is definitively the fastest horse overall. No other horse can be faster. 🥳

***

### Step 3: The Final Race for 2nd and 3rd (1 Race)
This is the most critical step. We need to find the horses that could *potentially* be 2nd or 3rd fastest overall.

Let's analyze what we know from the 6th race (A1 > B1 > C1 > D1 > E1):

* **Eliminate the slow horses:** D1 and E1 finished 4th and 5th in the winners' race. This means they cannot be in the top 3 overall. Furthermore, every horse in their original groups (D2, D3... and E2, E3...) is slower than them, so we can eliminate all horses from **groups D and E**.
* **Identify the contenders:** Who is left that could possibly be 2nd or 3rd?
    1.  The horses that finished 2nd and 3rd in the winners' race: **B1** and **C1**. They lost to A1 but could still be 2nd or 3rd.
    2.  The horses that were beaten by the overall winner (A1) in its initial race: **A2** and **A3**. It's possible A2 is faster than B1 and C1.
    3.  The horse that was beaten by the 2nd place contender (B1) in its initial race: **B2**. It's possible that A1 is a super horse and B2 is faster than C1.

Let's refine this list. Can C2 or A3 be the 2nd fastest horse? No.
* C2 is slower than C1. C1 is slower than B1. B1 is slower than A1. So, C2 is already slower than at least three horses (C1, B1, A1) and cannot be 2nd or 3rd.
* By the same logic, A3 is slower than A2 and A1. A2 is potentially 2nd or 3rd, but A3 cannot be.

This leaves us with a final pool of 5 contenders for the 2nd and 3rd spots:
* **A2:** The 2nd horse from the champion's group.
* **B1:** The 2nd place horse from the winners' race.
* **B2:** The 2nd horse from B1's group.
* **C1:** The 3rd place horse from the winners' race.

Wait, let's re-evaluate. My previous elimination was too aggressive. The key is to find any horse that has been beaten by at most *one* other confirmed faster horse. Let's restart the contenders list for 2nd and 3rd, knowing **A1** is 1st.

A contender for 2nd place is any horse that was only beaten by A1.
* **A2** (lost to A1 in Race 1)
* **B1** (lost to A1 in Race 6)

A contender for 3rd place is any horse beaten by A1, or by a potential 2nd place horse.
* **A3** (lost to A1, A2 in Race 1)
* **B2** (lost to B1 in Race 2)
* **C1** (lost to A1, B1 in Race 6)

Combining these candidates gives us the 5 horses for our final race: **A2, A3, B1, B2, and C1**.

Now, we run our **7th race** with these 5 horses.

* **The 2nd Fastest Horse:** The winner of this 7th race is the 2nd fastest horse overall. 🥈
* **The 3rd Fastest Horse:** The horse that finishes second in this 7th race is the 3rd fastest horse overall. 🥉

## Summary of Races
* **Races 1-5:** Initial heats to categorize all 25 horses.
* **Race 6:** Race of the winners to find the #1 fastest horse.
* **Race 7:** Race of the potential #2 and #3 horses to determine the final rankings.

**Total = 7 races.**