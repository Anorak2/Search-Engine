FROM node:20-alpine AS base

# Enable corepack and activate pnpm
RUN corepack enable && corepack prepare pnpm@latest --activate

WORKDIR /app

# Dependencies stage
# ----------------------------------------------------------------------------
FROM base AS dependencies

# Copy package files
COPY src/frontend/package.json .
COPY src/frontend/pnpm-lock.yaml .

# Install dependencies
RUN pnpm install --frozen-lockfile

# Development stage
# ----------------------------------------------------------------------------
FROM base AS development

# Copy dependencies from dependencies stage
COPY --from=dependencies /app/node_modules ./node_modules

# Copy source code
COPY src/frontend/ .

# Expose Vite dev server port
EXPOSE 5173

# Run Vite dev server
CMD ["pnpm", "run", "dev", "--host"]
