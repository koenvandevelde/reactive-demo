const http = require("http");
const url = "http://localhost:8080/user";
const numberOfRequests = 50;


console.log('can our spring rest endpoint handle ' + numberOfRequests  + ' concurrent transactions?')
for(var i = 0; i < numberOfRequests;i++){

    console.log(new Date().toISOString() + ' sending request ' + i);
    http.get(url, res => {
        res.setEncoding("utf8");
        let body = "";
        res.on("data", data => {
          body += data;
        });
        res.on("end", () => {
          body = JSON.parse(body);
          console.log(body);
        });
      });
}
