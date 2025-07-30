var express = require('express');
var app = express();

var port = 8080;

app.use(express.static('public')); // Serve static files from the 'public' directory

app.listen(port, function() {
    console.log('Server is running on http://localhost:' + port);
});

