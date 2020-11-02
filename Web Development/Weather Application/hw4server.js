var express = require("express");
var request = require('request');
var app = express();
app.use(express.static("public"))

app.get('/forecasts', function (req, res) {
  var URL = "https://api.aerisapi.com/forecasts";
  URL += "/" + req.query.lon + "," + req.query.lat + "?&format=json&filter=day&limit=7&fields=periods.dateTimeISO,periods.maxTempF,periods.weather&client_id=" + "GQScHL6jLg1CPWErSameQ" + "&client_secret=" + "LRIpdBVDN7ttYl0gTWcfbx7Wb7877cTgCZB8q5vd";
  //https://api.aerisapi.com/forecasts/12.7,64.8?&format=json&filter=day&limit=7&client_id=CLIENT_ID&client_secret=CLIENT_SECRET
  request.get(URL, function(error, response, body) {
    res.type("application/json");
    res.send(body);
  });
});

app.listen(8080);
