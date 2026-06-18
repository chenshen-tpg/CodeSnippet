# 🚀 Algorithm Solutions Viewer

An interactive web interface to browse, search, and view all your coding solutions from the Algorithms folder.

## Features

✨ **Search & Filter** — Find solutions by problem name, class name, or problem ID  
🎯 **Difficulty Levels** — Filter by Normal, Medium, or Hard  
📝 **Code Preview** — See code snippets in the problem list  
💻 **Syntax Highlighting** — Full Java syntax highlighting in the viewer  
📱 **Responsive Design** — Works on desktop and mobile  
⚡ **Fast Loading** — Pre-indexed problems for instant access  

## Quick Start

### 1. Install Dependencies
```bash
cd /Users/chen.shen/IdeaProjects/Personal_Code/website
npm install
```

### 2. Build the Index
This scans all Java files in your Algorithms folder and builds a searchable index.
```bash
npm run index
```

Expected output:
```
Building index...
  Hard: XX solutions
  Medium: XX solutions
  Normal: XX solutions

✓ Index built: XXX total solutions
```

### 3. Start the Server
```bash
npm start
```

Server will run at: **http://localhost:3000**

```
╔════════════════════════════════════════╗
║   Coding Solutions Viewer              ║
╚════════════════════════════════════════╝

✓ Server running at http://localhost:3000
```

### 4. Open in Browser
Navigate to **http://localhost:3000** and start exploring!

---

## How to Use

### Search
Type in the search box to filter by:
- Problem name (e.g., `LongestNice`)
- Class name (e.g., `SampleSol`)
- Problem ID (e.g., `1763`)

### Filter by Difficulty
Select a difficulty level from the dropdown (Normal, Medium, Hard, or All)

### View Code
Click on any problem card to view the full source code with syntax highlighting

### Mobile
On mobile devices, click a card to open the code panel. Use the ✕ button to close it.

---

## Project Structure

```
website/
├── package.json           # Dependencies
├── server.js              # Express backend
├── index-problems.js      # Index builder script
├── problems.json          # Generated index (created by "npm run index")
└── public/
    ├── index.html         # Frontend HTML
    ├── style.css          # Styling
    └── app.js             # Frontend JavaScript
```

---

## How It Works

1. **Indexing** (`index-problems.js`)
   - Scans `/maven/src/main/Coding/Algorithms/` recursively
   - Extracts problem metadata (name, ID, difficulty)
   - Generates `problems.json` with all solutions

2. **Backend** (`server.js`)
   - Express server serving the frontend
   - `/api/problems` — Returns filtered list of solutions
   - `/api/code/:problem/:class` — Returns full Java code

3. **Frontend** (`app.js`)
   - Real-time search and filtering
   - Click to load and syntax-highlight code
   - Responsive two-column layout (single column on mobile)

---

## Troubleshooting

### "problems.json not found"
Run: `npm run index`

### Server won't start
- Check if port 3000 is already in use
- Try: `PORT=3001 npm start`

### No problems showing up
1. Verify the Algorithms folder exists at:
   `/Users/chen.shen/IdeaProjects/Personal_Code/maven/src/main/Coding/Algorithms`
2. Re-run the indexer: `npm run index`
3. Check browser console for errors (F12)

### Can't load code
- Make sure the Java file exists in the expected location
- Re-index: `npm run index`

---

## Future Ideas

- Add syntax highlighting for other languages
- Export solutions as PDF
- Add problem difficulty statistics
- Dark/Light theme toggle
- Integration with LeetCode API
- Code execution in browser

---

## License

Personal use

