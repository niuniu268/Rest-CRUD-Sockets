# Rest CRUD & Sockets

## Aims

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
- After progamming, users visit website http://127.0.0.1:8080/channel (get). user can see the image listed below.
![image 1](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot1.png)
- Users also can successfully connect a websocket when they visit website: ws://127.0.0.1:8080/broadcast
![image 2](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot2.png)
- Users can apply a post request to add a new channel
![image 3](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot3.png)
- After handing in a new channel, users can check the information (get)
![image 4](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot4.png)
- Meanwhile, the broadcast channel also updates the submitted channel.
![image 5](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot5.png)
- When users want to remove a channel (channel 15, 'ten'), they can apply a delete request
![image 6](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot6.png)
- So users can check the updated information 
![image 7](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot7.png)
- Users can talk with each other when they visit the website: ws://127.0.0.1/sub
![image 8](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot8.png)
![image 9](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot9.png)
- Users can send a message by means of JSON format. Others in the channel can receive this message.
![image 10](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot10.png)
![image 10](https://raw.githubusercontent.com/niuniu268/Rest-CRUD-Sockets/master/img/Screenshot11.png)
