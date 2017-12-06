CREATE TABLE project_details (
  ID SERIAL PRIMARY KEY,
  TITLE VARCHAR(500) NOT NULL,
  DESCRIPTION TEXT NOT NULL,
  CREATED_BY VARCHAR(255) NOT NULL,
  CREATED_ON timestamp without time zone NOT NULL
   DEFAULT (current_timestamp AT TIME ZONE 'UTC'));