FROM node:lts-alpine
ENV NODE_ENV=production
WORKDIR /usr/src/app
RUN npm install -g serve

COPY ./build /usr/src/app/build
EXPOSE 3000
# RUN chown -R node /usr/src/app
# USER node
CMD ["serve","-s", "build"]
