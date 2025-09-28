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
- [Question 5. Second Best Player in a Tournament](#question-5-second-best-player-in-a-tournament)
  - [Q1: Finding the Winner](#q1-finding-the-winner)
    - [The Simple Logic (The Losers Method)](#the-simple-logic-the-losers-method)
    - [The Mathematical Method (Summing Rounds)](#the-mathematical-method-summing-rounds)
  - [Q2: Finding the Second-Best Player](#q2-finding-the-second-best-player)
    - [The Critical Insight](#the-critical-insight)
    - [The Two-Step Process](#the-two-step-process)
  - [The Final Calculation](#the-final-calculation)
- [Question 6. 1000 Barrels of Wine](#question-6-1000-barrels-of-wine)
  - [The Solution: Using Binary Power](#the-solution-using-binary-power)
    - [1. Label Everything](#1-label-everything)
    - [2. Assign Prisoners to "Bits"](#2-assign-prisoners-to-bits)
    - [3. Administer the Wine](#3-administer-the-wine)
    - [4. Read the Result](#4-read-the-result)
  - [**A Worked Example**](#a-worked-example)
- [Question 7. 3 White and 2 Black Hats](#question-7-3-white-and-2-black-hats)
  - [**The Solution**](#the-solution)
    - [The First Level of Deduction (Eliminating a Scenario)](#the-first-level-of-deduction-eliminating-a-scenario)
    - [The Smartest Applicant's Deduction](#the-smartest-applicants-deduction)
  - [**The Solution**](#the-solution-1)
    - [Weighing #1](#weighing-1)
      - [**Scenario A: The Scale Balances**](#scenario-a-the-scale-balances)
      - [**Scenario B: The Left Side is Heavier ({1, 2, 3, 4} \> {5, 6, 7, 8})**](#scenario-b-the-left-side-is-heavier-1-2-3-4--5-6-7-8)
      - [**Scenario C: The Right Side is Heavier ({1, 2, 3, 4} \< {5, 6, 7, 8})**](#scenario-c-the-right-side-is-heavier-1-2-3-4--5-6-7-8)


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

## Solution

The final state of any door depends entirely on **how many times it was toggled**.
* All doors start closed.
* Toggled once: Closed → **Open**
* Toggled twice: Open → **Closed**
* Toggled three times: Closed → **Open**

A door will be left open only if it is toggled an **odd number of times**.

### The Rule: Who Toggles Which Door?

The number of times a specific door is toggled is determined by the puzzle's rule: "Person `n` toggles every `n`-th door."

Let's rephrase this from a door's perspective: Door #`D` is toggled by Person #`P` only if `D` is a multiple of `P`. This is the same as saying `P` must be a **factor** (or divisor) of `D`.

Therefore, the total number of times a door is toggled is equal to the **total number of factors** its number has.

Combining these insights: **A door will remain open only if its number has an odd number of factors.**

### The Math: Perfect Squares are Oddballs

So, which numbers have an odd number of factors? Let's look at a few.

* **Factors of 10:** 1, 10, 2, 5 (4 factors - an even number)
* **Factors of 12:** 1, 12, 2, 6, 3, 4 (6 factors - an even number)

Factors usually come in pairs. For the number 12, the pairs are (1, 12), (2, 6), and (3, 4). This pairing system almost always results in an even number of factors.

The only way a number can have an odd number of factors is if one of the pairs is not a pair at all, but a single number repeated. This happens when the number is a **perfect square**.

* **Factors of 9 (which is $3^2$):** 1, 9, **3** (3 factors - an odd number). The "pair" for 3 would be $9/3 = 3$, so it's only counted once.
* **Factors of 16 (which is $4^2$):** 1, 16, 2, 8, **4** (5 factors - an odd number).

So, the doors that remain open are those whose numbers are perfect squares. ✅

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

### The Solution: The Parity Strategy

The solution hinges on the group making a shared, arbitrary assumption **beforehand**. The most common and effective strategy is based on **parity** (whether a number is odd or even).

### The Strategy (Agreed upon in the dark room)

The group must agree on two things:

1.  **Designated Sides:** They designate one side of the room for the "Black Caps" group and the opposite side for the "White Caps" group.
2.  **The Core Assumption:** Everyone agrees to act based on the following shared assumption: **"The total number of black caps in the entire room is an ODD number."**

This assumption might be false in reality, but that doesn't matter, as long as everyone uses it for their logic.

### How an Individual Decides

Once they are in the lit room, each person counts the number of black caps they can see on everyone else. Let's say you are one of the people in the room.

* **Scenario A: You see an EVEN number of black caps.**
    * Your Logic: "I see an even number of black caps. Our group's assumption is that the total number of black caps is **odd**. If my own cap were white, the total number of black caps would remain even, which contradicts our assumption. Therefore, my cap **must be black** to make the total odd."
    * Your Action: You walk to the designated "Black Caps" side of the room.

* **Scenario B: You see an ODD number of black caps.**
    * Your Logic: "I see an odd number of black caps. Our group's assumption is that the total number of black caps is **odd**. If my own cap were black, the total would become even, contradicting our assumption. Therefore, my cap **must be white** to keep the total odd."
    * Your Action: You walk to the designated "White Caps" side of the room.

Since every person follows this exact same logic, they can all make a decision and move simultaneously.

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


# Question 5. Second Best Player in a Tournament

In a single-elimination (knockout) tournament with $2^n$ players, every match results in one winner and one loser, with the loser being eliminated.
1.  What is the total number of matches required to determine the tournament champion?
2.  What is the minimum number of matches required to find the **true second-best player**? (Note: The player who loses in the final match is not necessarily the second-best overall).

## Q1: Finding the Winner

It takes **$2^n - 1$** matches to find the winner.

There are two ways to think about this, one simple and one more mathematical.

### The Simple Logic (The Losers Method)
This is the most elegant way to solve it. In any tournament, there can be only one winner. If there are $2^n$ players, this means there must be $2^n - 1$ losers. Since each match produces exactly one loser, you must play **$2^n - 1$** matches to produce $2^n - 1$ losers. It's that simple!

### The Mathematical Method (Summing Rounds)
You can also add up the matches in each round:
* **Round 1:** $2^n$ players form $2^{n-1}$ matches.
* **Round 2:** $2^{n-1}$ players form $2^{n-2}$ matches.
* ...
* **Final Round (Round n):** 2 players form 1 match.

The total is the sum of a geometric series: $2^{n-1} + 2^{n-2} + ... + 2^1 + 1 = 2^n - 1$.

**Example (for 8 players, where $n=3$):**
The total matches are $8 - 1 = \textbf{7}$. (This matches your calculation of 4+2+1=7).

## Q2: Finding the Second-Best Player

It takes **$2^n + n - 2$** matches to find the true second-best player.

This is trickier because the player who loses in the final isn't guaranteed to be the second best. The true second-best player could have been eliminated by the champion in any round.

### The Critical Insight
The only player who could have possibly defeated the true second-best player is the **champion**. Therefore, the second-best player must be one of the players who lost directly to the champion during the tournament.

### The Two-Step Process

1.  **Step 1: Find the Champion.**
    As we found in Q1, this requires **$2^n - 1$** matches. This step also reveals the champion's path to victory and all the opponents they defeated along the way.

2.  **Step 2: Find the Best of the Champion's Opponents.**
    In a tournament of $2^n$ players, there are $n$ rounds. The champion had to play and win one match in each round, meaning the champion defeated exactly **$n$ players**. These $n$ players are the only candidates for the title of "second-best."

    To find the best player among this group of $n$ candidates, we hold a separate knockout tournament for them. Using our logic from Q1, finding the winner among $n$ players requires **$n - 1$** matches.

## The Final Calculation

The total number of matches is the sum of the matches from both steps:

Total Matches = (Matches to find champion) + (Matches to find best of the rest)
Total Matches = $(2^n - 1) + (n - 1)$
Total Matches = $\mathbf{2^n + n - 2}$

**Example (for 8 players, where $n=3$):**
1.  **Find Champion:** It takes $2^3 - 1 = 7$ matches. The champion defeated 3 opponents (one in each of the 3 rounds).
2.  **Find Second-Best:** We take those 3 defeated opponents and hold a mini-tournament. To find the best of 3 players, it takes $3 - 1 = 2$ matches.
3.  **Total:** $7 + 2 = \textbf{9}$ matches.

Using the formula: $2^3 + 3 - 2 = 8 + 3 - 2 = 9$. It works perfectly!


# Question 6. 1000 Barrels of Wine

A king has 1000 barrels of wine for a party that is one week away. An assassin poisons exactly one of the barrels. The poison has a delayed effect: anyone who drinks it will die precisely one week later. The king has 10 prisoners whom he can use to test the wine.

How can the king devise a test using the prisoners to identify the single poisoned barrel within one week, ensuring the other 999 barrels are safe for the party?

## The Solution: Using Binary Power

The key is to realize that with 10 prisoners, you have 10 "bits" of information. At the end of the week, each prisoner will either be alive or dead, a binary state (0 or 1). With 10 bits, you can represent $2^{10} = 1024$ unique numbers, which is more than enough to identify one of the 1000 barrels.

Here is the step-by-step strategy:

### 1. Label Everything
First, the king must label the barrels of wine from **1 to 1000**. He must also label the prisoners from **1 to 10**.

### 2. Assign Prisoners to "Bits"
Each prisoner represents a specific position in a 10-digit binary number.
* **Prisoner #1** represents the 1's place (the rightmost bit, $2^0$)
* **Prisoner #2** represents the 2's place ($2^1$)
* **Prisoner #3** represents the 4's place ($2^2$)
* ...and so on, up to...
* **Prisoner #10** represents the 512's place ($2^9$)

### 3. Administer the Wine
This is the ingenious part. For each barrel, the king's servants convert its label number into its 10-bit binary equivalent. Then, a prisoner is given a tiny sip from that barrel **if and only if their corresponding bit is a '1'**.

Let's look at a few examples:
* **Barrel #1:** Binary is `0000000001`. Only the 1st bit is a '1'. So, **only Prisoner #1** drinks from Barrel #1.
* **Barrel #6:** Binary is `0000000110`. The 2nd and 3rd bits are '1'. So, **Prisoner #2 and Prisoner #3** both drink from Barrel #6.
* **Barrel #789:** Binary is `1100010101`. The 1st, 3rd, 5th, 9th, and 10th bits are '1'. So, **Prisoners #1, #3, #5, #9, and #10** all drink from Barrel #789.

This process is repeated for all 1000 barrels. Each prisoner will have a cup containing a mixture of sips from hundreds of different barrels.

### 4. Read the Result
After one week, the king lines up the surviving prisoners in order from #10 down to #1. He then creates a new 10-bit binary number based on the outcome:
* If a prisoner is **dead**, he writes a **1** in their bit position.
* If a prisoner is **alive**, he writes a **0** in their bit position.

The resulting binary number, when converted back to decimal, is the number of the poisoned barrel!

## **A Worked Example**
Let's say after one week, the king observes the following:
* Prisoners #1, #4, and #8 are **dead**.
* All other prisoners are **alive**.

He would construct the binary number like this (from Prisoner #10 down to #1):

| Prisoner | 10  | 9   | 8   | 7   | 6   | 5   | 4   | 3   | 2   | 1   |
| :------- | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
| Status   | A   | A   | D   | A   | A   | A   | D   | A   | A   | D   |
| **Bit** | **0** | **0** | **1** | **0** | **0** | **0** | **1** | **0** | **0** | **1** |

The binary result is `0010001001`.
Converting this back to decimal:
$2^7 + 2^3 + 2^0 = 128 + 8 + 1 = 137$.

The king can declare with certainty that **Barrel #137** was the poisoned one. This works because Barrel #137 is the *only* barrel that was sampled by *exactly* that combination of prisoners. 🧪


# Question 7. 3 White and 2 Black Hats

A shopkeeper wishes to hire the smartest of three applicants. He shows them a box containing **3 white caps and 2 black caps**. He explains that he will place one cap on each of their heads while their eyes are closed, and hide the remaining two caps.

The applicants are positioned in a triangle, so each person can see the caps of the other two, but not their own.

The shopkeeper asks, "If you know the color of your own cap, raise your hand."

No one raises their hand.

The shopkeeper asks a second time, "Again, if you know the color of your own cap, raise your hand."

After a moment, the smartest applicant raises his hand and correctly states, "My cap is white." How did he figure it out?

## **The Solution**

The solution lies in a step-by-step process of elimination, where the silence of the other applicants becomes a powerful clue. Let's call the applicants **A**, **B**, and **C**. The smartest one is **C**.

### The First Level of Deduction (Eliminating a Scenario)
The first thing everyone does is look at the other two caps. There's one specific scenario that would lead to an immediate answer:

* **If any applicant saw two black caps** on the other two people, they would instantly know their own cap must be white. Why? Because there are only two black caps in total.

When the shopkeeper asks the first time and **no one raises their hand**, everyone in the group can deduce a critical piece of information: **"No one is seeing two black caps."** This is now common knowledge.

### The Smartest Applicant's Deduction
Now, let's see the situation from the perspective of the smartest applicant, C. After the first silence, she knows that the combination of (Black, Black) doesn't exist on A and B. She then reasons through the remaining possibilities of what she sees.

The crucial step is for C to analyze what would happen if her own cap were black.

* **C's Hypothesis:** "Let me assume my cap is **black**."
* **C's Reasoning:** "If my cap is black, then Applicant A would be seeing one white cap (on B) and one black cap (on me). Applicant A is also smart and knows that no one saw two black caps in the first round."
* **C thinks from A's perspective:** "A would think: 'I see a white cap on B and a black cap on C. If my own cap were also black, then B would be seeing two black caps (on me and C). But B was silent, so B is not seeing two black caps. Therefore, my cap must be **white**.'"
* **The Contradiction:** C realizes that if her own cap were black, the intelligent Applicant A would have been able to figure out his cap was white after the first round of silence.

But Applicant A **did not** raise his hand. A's silence is the final clue.

* **C's Conclusion:** "Since A was silent, my initial assumption must be wrong. My cap cannot be black."

Therefore, C confidently concludes: **"My cap must be white."** 🏆




There are 12 coins, all identical, except one which is either heavier or lighter. You have a balance scale and can use it only 3 times. How can you find the odd coin and determine whether it is heavier or lighter?

## **The Solution**

First, **label the coins 1 through 12**.

The entire strategy hinges on the first weighing. You must divide the coins into three groups of four.
* **Group 1:** {1, 2, 3, 4}
* **Group 2:** {5, 6, 7, 8}
* **Group 3:** {9, 10, 11, 12}

### Weighing #1
Place **Group 1** on the left pan and **Group 2** on the right pan. This leaves Group 3 off the scale. There are three and only three possible outcomes. We will follow each one to its conclusion.

#### **Scenario A: The Scale Balances**
* **Deduction:** If the scale balances, all eight coins on it ({1, 2, 3, 4, 5, 6, 7, 8}) are genuine. The odd coin must be in Group 3: {9, 10, 11, 12}. You have two weighings left.
* **Weighing #2 (Scenario A):** Weigh **{9, 10, 11}** against three known genuine coins, like **{1, 2, 3}**.
    * **Outcome A.1: It balances again.**
        * **Deduction:** Since {9, 10, 11} are the same weight as genuine coins, the odd one must be **#12**.
        * **Weighing #3:** Weigh coin **#12** against a genuine coin **#1**. If #12 goes down, it's **heavy**. If it goes up, it's **light**. **Problem solved.**
    * **Outcome A.2: {9, 10, 11} is heavier than {1, 2, 3}.**
        * **Deduction:** The odd coin is one of {9, 10, 11}, and it is **heavy**.
        * **Weighing #3:** Weigh coin **#9** against coin **#10**. If one goes down, that is the heavy coin. If they balance, **#11** is the heavy coin. **Problem solved.**
    * **Outcome A.3: {9, 10, 11} is lighter than {1, 2, 3}.**
        * **Deduction:** The odd coin is one of {9, 10, 11}, and it is **light**.
        * **Weighing #3:** Weigh coin **#9** against coin **#10**. If one goes up, that is the light coin. If they balance, **#11** is the light coin. **Problem solved.**

#### **Scenario B: The Left Side is Heavier ({1, 2, 3, 4} > {5, 6, 7, 8})**
* **Deduction:** This means one of two things:
    1.  One of the coins in {1, 2, 3, 4} is **heavy**.
    2.  One of the coins in {5, 6, 7, 8} is **light**.
    * We also know that coins {9, 10, 11, 12} are all genuine.
* **Weighing #2 (Scenario B):** This is the most brilliant step. We mix the groups. Weigh **{1, 2, 5}** against **{3, 6, 9}**.
    * **Outcome B.1: The scale balances.**
        * **Deduction:** The odd coin was not on the scale. The remaining suspects are {4} (which would be heavy) or {7, 8} (which would be light).
        * **Weighing #3:** Weigh **#7** against **#8**. If they balance, then **#4** is the odd coin, and it is **heavy**. If they don't balance, whichever one goes up is the **light** coin. **Problem solved.**
    * **Outcome B.2: The left side is heavier ({1, 2, 5} > {3, 6, 9}).**
        * **Deduction:** This result could only happen if either **#1 or #2 is heavy**, or if **#6 is light**. (Think about it: if #5 were light, the left side would go up. If #3 were heavy, the right side would go down).
        * **Weighing #3:** Weigh **#1** against **#2**. If they balance, then **#6** is the odd coin, and it is **light**. If one coin goes down, that is the **heavy** coin. **Problem solved.**
    * **Outcome B.3: The right side is heavier ({1, 2, 5} < {3, 6, 9}).**
        * **Deduction:** This result could only happen if **#3 is heavy** or **#5 is light**.
        * **Weighing #3:** Weigh **#3** against a genuine coin **#9**. If it goes down, **#3** is the **heavy** coin. If it balances, then **#5** must be the odd coin, and it is **light**. **Problem solved.**

#### **Scenario C: The Right Side is Heavier ({1, 2, 3, 4} < {5, 6, 7, 8})**
* **Deduction:** This scenario is perfectly symmetrical to Scenario B. The odd coin is either in {1, 2, 3, 4} and is **light**, or in {5, 6, 7, 8} and is **heavy**.
* The exact same moves from Scenario B will solve the puzzle; the deductions are just reversed.
    * **Let's follow one example path:** You perform the same second weighing: **{1, 2, 5}** vs **{3, 6, 9}**.
    * Imagine the right side goes down again ({1, 2, 5} < {3, 6, 9}).
        * **Deduction:** Remember, our suspects for this scenario are {1,2,3,4} (light) or {5,6,7,8} (heavy). This result could only happen if **#5 is heavy** or if **#1 or #2 is light**.
        * **Weighing #3:** Weigh **#1** against **#2**. If they balance, **#5** is the odd coin and is **heavy**. If one coin goes up, that is the **light** coin. **Problem solved.**