AI Tool Used: ChatGPT

Full Conversation Transcript:

User: Requested guidance on implementing Task and TaskManager classes based on CRC cards.

ChatGPT: Provided structural guidance for both classes, including recommended use of a HashMap to support efficient lookup, duplicate prevention, and task storage.


Output:
OPEN TASKS
T1 Write report [OPEN]
T3 Submit homework [OPEN]

TESTING DUPLICATE TASK ID
Duplicate task ID detected.

TESTING INVALID STATUS
T4 Invalid status test [UNKNOWN]

TESTING FIND TASK
T2 Study for exam [IN_PROGRESS]
Task not found.

ChatGPT: Confirmed that the output matched expected results and validated correctness.

Debugging and Verification Process:

During implementation, the following questions and checks were used to verify correctness:

- Does the data structure prevent duplicate task IDs efficiently?
  → Confirmed by using a HashMap and checking containsKey() before insertion.

- What happens when setStatus() receives an invalid value?
  → Verified that the status defaults to "UNKNOWN".

- Does getTasksByStatus() correctly filter only matching tasks?
  → Tested by updating one task to IN_PROGRESS and confirming it no longer appears in OPEN tasks.

- Is the output format exactly as required?
  → Verified the toString() method produces: taskId description [status].

- What happens when searching for a non-existent task?
  → Confirmed that findTask() returns null and is handled properly in Driver.

- Are all edge cases handled?
  → Tested:
     - Duplicate task insertion
     - Invalid status assignment
     - Task lookup failure

- Does the implementation match expected runtime behavior?
  → Compared program output line-by-line with the provided expected output.

Explanation:
ChatGPT was used as a reference tool to validate design decisions, clarify implementation details, and assist in debugging. 
