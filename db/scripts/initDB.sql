CREATE TABLE user_details (
  ID SERIAL PRIMARY KEY,
  FIRSTNAME VARCHAR(255) NOT NULL,
  LASTNAME VARCHAR(255) NOT NULL
);

INSERT INTO user_details (FIRSTNAME, LASTNAME)
VALUES ('Rohit', 'Mehra'), ('Ankit', 'Srivastava'), ('Nikhil', 'Sulegaon');