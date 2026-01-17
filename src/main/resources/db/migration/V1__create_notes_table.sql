CREATE TABLE notes (
                       id UUID PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       content TEXT NOT NULL,
                       created_at TIMESTAMP NOT NULL
);