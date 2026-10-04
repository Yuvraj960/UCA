# UCA

A curated learning repository covering data structures, algorithms, operating systems, computer networking, SQL, DevOps, and full-stack web development. The projects and exercises here are mostly academic and hands-on practice material built while learning core CS concepts and modern web tooling.

## Overview

This repository brings together multiple topics that are commonly taught in software engineering and computer science courses:

- Problem solving and algorithmic thinking
- Data structures and design patterns
- C and Java implementation practice
- SQL and database querying
- Operating system concepts
- Computer networking fundamentals
- Docker and container-based deployment
- Frontend development basics and React/Next.js projects
- Puzzles and reasoning-based interview prep

## Repository structure

```text
UCA/
├── CN/
│   ├── TCP_Server/
│   │   ├── EchoClient.java
│   │   └── EchoServer.java
│   └── UDP_Server/
│       └── EchoServer.java
├── Code Problems/
├── Complexity Analysis/
│   └── ComplexityAnalysis.c
├── DevOps/
│   ├── README.md
│   └── docker-compose.yml
├── OS/
│   └── OS Level Memory Management/
│       ├── Mem_Management_Double_Defrag.c
│       └── OS_Memory_Management.c
├── Problem Solving/
│   ├── Bitwise/
│   ├── Binary Search/
│   ├── Binary Search Trees/
│   ├── Disjoint Sets/
│   ├── Dynamic Programming/
│   ├── Fenwick Tree/
│   ├── File Handling/
│   ├── Graphs/
│   ├── Hash Tables/
│   ├── HashMaps/
│   ├── Hashing/
│   ├── LinkedList/
│   ├── PriorityQueues/
│   ├── Queues/
│   ├── Recursion/
│   ├── Scheduling Algorithms/
│   ├── SegmentTrees/
│   ├── Sorting Algorithms/
│   ├── Stacks/
│   ├── Sum_Even_Fibonacci/
│   ├── Threads/
│   ├── Trees/
│   ├── Trie/
│   ├── Two Pointer/
│   ├── remove_class_files.sh
│   ├── run_tests.sh
│   └── script_setup.sh
├── Puzzles/
│   └── Puzzles.md
├── SQL/
│   ├── README.md
│   ├── Solutions.md
│   ├── movieinfo.db
│   └── ratings.sql
├── Web Development/
│   ├── JavaScript Concepts/
│   ├── Next/
│   ├── React/
│   ├── Web Basics/
│   └── README.md (if present in subfolder)
├── rule-of-thumb-latency-numbers-letter.pdf
├── README.md
└── .gitignore
```

## What is included

### 1. Problem Solving and DSA
The `Problem Solving` folder contains implementations and practice for many classic topics:

- Arrays and sorting
- Trees and graphs
- Queues, stacks, and linked lists
- Hashing and hash maps
- Segment trees, Fenwick trees, and disjoint sets
- Dynamic programming and recursion
- Bitwise operations and scheduling algorithms

This work is focused on improving logic, code quality, and interview-style reasoning.

### 2. SQL and database assignments
The `SQL` directory includes a SQLite database, schema/input files, and query solutions for a movie-review assignment. It demonstrates practical SQL usage such as:

- JOINs and filtering
- Aggregation and grouping
- Subqueries and nested logic
- Ranking/filtering queries
- Database analysis in SQL

### 3. Operating systems and memory management
The `OS` folder contains C programs related to memory management and simulated allocation/defragmentation techniques.

### 4. Computer networking
The `CN` folder contains Java socket-based examples for:

- TCP echo client/server communication
- UDP-based echo server behavior

These are useful for learning the basics of network programming and inter-process communication.

### 5. DevOps and Docker
The `DevOps` folder includes a Docker Compose configuration representing a full-stack application with:

- Frontend service
- Backend API service
- PostgreSQL database

This is a good example of multi-container orchestration and deployment packaging.

### 6. Web development
The `Web Development` area includes:

- basic HTML/CSS/JS front-end work
- React interface examples
- Next.js app setup and frontend development
- JavaScript learning exercises

The Next.js app uses JavaScript and modern app conventions with ESLint and Tailwind/PostCSS configuration.

### 7. Puzzles and reasoning
The `Puzzles` directory contains puzzle walkthroughs and analytical write-ups to strengthen logical reasoning, probability understanding, and problem decomposition.

### 8. Complexity analysis
The `Complexity Analysis` folder contains a C program that compares algorithm runtime behavior across different input sizes and patterns (random, ascending, descending), helping visualize sorting complexity in practice.

## Tech stack

This repository includes a mix of core technologies and learning tools:

- C
- Java
- SQL / SQLite
- JavaScript
- React
- Next.js
- Docker / Docker Compose
- GNU/Linux shell scripting

## Getting started

### C / algorithm programs
Compile and run C code with GCC:

```bash
gcc "Problem Solving/Sorting Algorithms/quickSort.c" -o quicksort
./quicksort
```

### Java networking examples
Compile and run a Java socket program:

```bash
javac "CN/TCP_Server/EchoServer.java"
java -cp "CN/TCP_Server" EchoServer
```

### SQLite database
Open or populate the SQL database:

```bash
sqlite3 "SQL/movieinfo.db" < "SQL/ratings.sql"
```

### Next.js app
Run the frontend app in the Next.js project:

```bash
cd "Web Development/Next"
npm install
npm run dev
```

Then open:

```text
http://localhost:3000
```

### Docker Compose
Run the Docker example:

```bash
cd DevOps
docker compose up --build
```

## Notes

- This is a personal academic and practice repository, not a production application.
- The content is organized by learning topic rather than by one single product or system.
- Many directories contain standalone exercises and sample implementations that can be explored independently.

## Learning goals

This repository is intended to help build practical understanding in:

- algorithm design
- coding fundamentals
- database querying
- distributed system basics
- frontend development
- deployment workflows
- interview-style reasoning

