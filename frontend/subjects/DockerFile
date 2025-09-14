FROM node:22.12.0-alpine AS builder
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
RUN npm run build --configuration=production

FROM nginx:latest
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /app/dist/subjects/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 4200
CMD ["nginx", "-g", "daemon off;"]
