# --- Build stage ---
FROM node:20-alpine AS build
WORKDIR /app

COPY . .

ARG VITE_API_BASE_URL
ENV VITE_API_BASE_URL=$VITE_API_BASE_URL

RUN npm install
RUN npm run build

# --- Serve stage ---
FROM nginx:1.27-alpine AS serve
# Remove default site to avoid port 80 conflicts
RUN rm -f /etc/nginx/conf.d/default.conf

# Copy our nginx site config
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copy built assets
COPY --from=build /app/dist /usr/share/nginx/html

# Optional: healthcheck
HEALTHCHECK --interval=30s --timeout=3s CMD wget -qO- http://localhost/ || exit 1

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
