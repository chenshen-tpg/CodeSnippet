const express = require('express');
const cors = require('cors');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3001;

app.use(cors());
app.use(express.static('public'));

const ALGORITHMS_PATH = path.join(__dirname, '..', 'maven', 'src', 'main', 'Coding', 'Algorithms');
const PROBLEMS_FILE = path.join(__dirname, 'problems.json');

// Load problems index
let problemsIndex = [];
if (fs.existsSync(PROBLEMS_FILE)) {
  problemsIndex = JSON.parse(fs.readFileSync(PROBLEMS_FILE, 'utf8'));
} else {
  console.warn('⚠ problems.json not found. Run: npm run index');
}

// API: Get all problems (with optional filtering)
app.get('/api/problems', (req, res) => {
  const { search, difficulty } = req.query;

  let filtered = problemsIndex;

  if (search) {
    const q = search.toLowerCase();
    filtered = filtered.filter(p =>
      p.name.toLowerCase().includes(q) ||
      p.class.toLowerCase().includes(q) ||
      p.problemId.includes(q)
    );
  }

  if (difficulty && difficulty !== 'All') {
    filtered = filtered.filter(p => p.difficulty === difficulty);
  }

  res.json(filtered);
});

// API: Get code for a specific file
app.get('/api/code/:problemName/:className', (req, res) => {
  const { problemName, className } = req.params;
  const fileName = `${className}.java`;

  const filePath = path.join(ALGORITHMS_PATH, '**', problemName, fileName);

  // Find the actual file (it could be in Hard, Medium, or Normal folder)
  let actualPath = null;
  for (const difficulty of ['Hard', 'Medium', 'Normal']) {
    const testPath = path.join(ALGORITHMS_PATH, difficulty, problemName, fileName);
    if (fs.existsSync(testPath)) {
      actualPath = testPath;
      break;
    }
  }

  if (!actualPath) {
    return res.status(404).json({ error: 'File not found' });
  }

  try {
    const code = fs.readFileSync(actualPath, 'utf8');
    res.json({ code });
  } catch (e) {
    res.status(500).json({ error: e.message });
  }
});

app.listen(PORT, () => {
  console.log(`
╔════════════════════════════════════════╗
║   Coding Solutions Viewer              ║
╚════════════════════════════════════════╝

✓ Server running at http://localhost:${PORT}

To get started:
  1. npm install
  2. npm run index    (build problems index)
  3. npm start        (start server)

Then open http://localhost:${PORT} in your browser.
  `);
});

