\c search_db

-- Grant necessary permissions
GRANT ALL PRIVILEGES ON DATABASE search_db TO app_user;

-- Create development schema (in addition to public)
CREATE SCHEMA IF NOT EXISTS dev;
GRANT ALL PRIVILEGES ON SCHEMA dev TO app_user;

-- Log successful initialization
DO $$
BEGIN
    RAISE NOTICE 'feedback database initialized successfully';
END $$;
