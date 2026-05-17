let app;
app.post('/login', (req, res) => {
    const {username, password} = req.body;
    if (username === 'admin' && password === 'admin') {
        res.send('Welcome admin!');
    } else {
        res.status(401).send('Unauthorized');
    }
});


app.post('/login', (req, res) => {
    const {username, password} = req.body;
    if (username === 'admin' && password === 'admin') {
        res.send('Welcome admin!');
    } else {
        res.status(401).send('Unauthorized');
    }
});