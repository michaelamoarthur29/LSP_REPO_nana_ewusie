TaskManager collaborates with Task because it is responsible for storing, retrieving, and organizing Task objects. It needs to interact with Task instances to perform operations like adding, searching, and filtering tasks by status.

Task does not collaborate with TaskManager because its responsibility is limited to managing its own data (taskId, description, status) and updating its status. It does not need to know about or manage other tasks.
