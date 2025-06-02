CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE blogpost (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(400) NOT NULL,
    category VARCHAR(100) NOT NULL,
    tags TEXT[],
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);