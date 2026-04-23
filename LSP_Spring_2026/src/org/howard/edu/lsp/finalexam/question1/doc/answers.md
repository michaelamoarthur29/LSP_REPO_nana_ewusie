## Part 1:
Shared Resource #1:
nextId

Shared Resource #2:
requests list

Concurrency Problem:
Race condition

Why addRequest() is unsafe:
Multiple threads can call getNextId() at the same time, causing duplicate IDs. Also, ArrayList is not thread-safe, so concurrent modifications to requests can lead to inconsistent state or data corruption.

## Part 2:
Fix A:
Incorrect. Synchronizing getNextId() ensures unique IDs, but requests list is still modified unsafely since addRequest() is not synchronized.

Fix B:
Correct. Synchronizing addRequest() ensures both ID generation and list modification happen atomically, preventing race conditions and ensuring thread safety.

Fix C:
Incorrect. Synchronizing getRequests() only protects reading the list, but does not prevent concurrent modification issues during addRequest().

## Part 3:
Answer + Explanation:
No, getNextId() should not be public. According to Riel’s heuristics, methods that manage internal state should be hidden. Making it private preserves encapsulation and prevents misuse or inconsistent state changes from outside the class.

## Part 4:
Description:
Use an AtomicInteger to generate thread-safe unique IDs without using synchronized. Atomic operations ensure that incrementing the ID is safe even with multiple threads.

Code Snippet:
private AtomicInteger nextId = new AtomicInteger(1);

public void addRequest(String studentName) {
    int id = nextId.getAndIncrement();
    String request = "Request-" + id + " from " + studentName;
    synchronized (requests) {
        requests.add(request);
    }
}
