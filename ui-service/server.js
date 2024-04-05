const express = require('express');
const path = require('path');

const app = express();

app.use(express.static(path.join(__dirname, 'public')));
app.use('/scripts', express.static(__dirname + '/node_modules/'));

app.get('/orders', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'orders.htm'));
});
app.get('/create_order', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'create_order.htm'));
});
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.htm'));
});
app.use((req, res, next) => {
    res.status(404).sendFile(path.join(__dirname, 'public', '404.htm'));
});




const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});