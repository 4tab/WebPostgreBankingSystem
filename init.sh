#!/bin/bash

set -e  # stop on error

echo "Initializing PostgreSQL..."

sudo -u postgres psql <<EOF
ALTER USER postgres WITH PASSWORD 'postgres123';

DO \$\$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'banking_db') THEN
      CREATE DATABASE banking_db;
   END IF;
END
\$\$;

DO \$\$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_roles WHERE rolname = 'banking') THEN
      CREATE USER banking WITH PASSWORD 'bank123';
   END IF;
END
\$\$;

GRANT ALL PRIVILEGES ON DATABASE banking_db TO banking;
EOF

echo "Done."