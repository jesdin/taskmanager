TRUNCATE TABLE Task
GO

INSERT INTO Task (Title, IsHighPriority, IsCompleted)
VALUES
    ('Buy Eggs', 0, 0),
    ('Complete Data Structure Assignment', 1, 0),
    ('Play Free Fire', 0, 1)
GO

-- return the contents of Task Table
SELECT * 
FROM Task;
GO