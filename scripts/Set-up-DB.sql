CREATE DATABASE TaskManagerDB
GO

USE TaskManagerDB
GO

CREATE TABLE Task (
  Id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
  Title nvarchar(255) NOT NULL,
  IsHighPriority BIT NOT NULL,
  IsCompleted BIT NOT NULL,
);
GO