# Rest CRUD & Sockets

## aims

REST API endpoints
1. [GET] /channels/ ← Hämtar en lista över annonserade kanaler
2. [POST] - /channels/ ← skapar en ny kanal som annonseras i den permanenta
   chatt-kanalen.
3. [DELETE] /channels/{id} ← tar bort en annonserad kanal
   Studerande väljer hur deltagare av borttagna kanaler hanteras. Det är ok att låta de vara kvar efter att annonsen är borttagen.
   Socket endpoints
1. /sub/channels/ ← en socket för den permanenta chatt-kanalen. Här skickas annonser som har skapats via POST förfrågan.
2. /sub/chat/ ← en (eller flera) socket där du ansluter mot en specifik kanal (via id-värde) och lyssnar på nya meddelanden från kanalen samt kan skicka tillbaka svar via samma socket. ***

## Preparations
1. Docker compose file
```
version: '3'
services:
  db:
    image: mariadb:latest
    environment:
      MYSQL_ROOT_PASSWORD: password
      MYSQL_DATABASE: test
      MYSQL_USER: niuniu
      MYSQL_PASSWORD: louis
    volumes:
      - .:/var/lib/mysql
    ports:
      - "3306:3306"
```

## Results
- after progamming, users visit website http://127.0.0.1:8080/channel (get)
![image 1]()
