let allProblems = [];
let currentProblem = null;

// Elements
const searchInput = document.getElementById('searchInput');
const difficultyFilter = document.getElementById('difficultyFilter');
const problemsContainer = document.getElementById('problemsContainer');
const problemCount = document.getElementById('problemCount');
const codePanel = document.getElementById('codePanel');
const codeTitle = document.getElementById('codeTitle');
const codeContent = document.getElementById('codeContent');
const codeContainer = document.getElementById('codeContainer');
const closeCodeBtn = document.getElementById('closeCodeBtn');

// Initialize
document.addEventListener('DOMContentLoaded', () => {
  loadProblems();
  setupEventListeners();
});

function setupEventListeners() {
  searchInput.addEventListener('input', debounce(filterProblems, 300));
  difficultyFilter.addEventListener('change', filterProblems);
  closeCodeBtn.addEventListener('click', closeCodePanel);
}

function loadProblems() {
  problemsContainer.innerHTML = '<div class="loading">Loading problems...</div>';

  fetch('/api/problems')
    .then(res => res.json())
    .then(problems => {
      allProblems = problems;
      filterProblems();
    })
    .catch(err => {
      console.error('Error loading problems:', err);
      problemsContainer.innerHTML = `<div class="empty-state"><p>⚠ Error loading problems. Make sure to run: npm run index</p></div>`;
    });
}

function filterProblems() {
  const search = searchInput.value.toLowerCase();
  const difficulty = difficultyFilter.value;

  let filtered = allProblems;

  if (search) {
    filtered = filtered.filter(p =>
      p.name.toLowerCase().includes(search) ||
      p.class.toLowerCase().includes(search) ||
      p.problemId.includes(search)
    );
  }

  if (difficulty !== 'All') {
    filtered = filtered.filter(p => p.difficulty === difficulty);
  }

  displayProblems(filtered);
}

function displayProblems(problems) {
  problemCount.textContent = problems.length;

  if (problems.length === 0) {
    problemsContainer.innerHTML = '<div class="empty-state"><p>No problems found</p></div>';
    return;
  }

  problemsContainer.innerHTML = problems.map(problem => `
    <div class="problem-card ${currentProblem && currentProblem.file === problem.file ? 'selected' : ''}" 
         data-file="${problem.file}"
         data-name="${problem.name}"
         data-class="${problem.class}">
      <h3>${problem.name}</h3>
      <div class="problem-meta">
        <span class="problem-id">#${problem.problemId}</span>
        <span class="difficulty-badge ${problem.difficulty}">${problem.difficulty}</span>
      </div>
      <div class="problem-class">${problem.class}</div>
      <div class="problem-preview">${problem.preview}</div>
    </div>
  `).join('');

  // Add click handlers
  document.querySelectorAll('.problem-card').forEach(card => {
    card.addEventListener('click', () => {
      const problemName = card.getAttribute('data-name');
      const className = card.getAttribute('data-class');
      loadCode(problemName, className, card);
    });
  });
}

function loadCode(problemName, className, cardElement) {
  // Update UI
  document.querySelectorAll('.problem-card').forEach(c => c.classList.remove('selected'));
  cardElement.classList.add('selected');

  // Show loading
  codeTitle.textContent = 'Loading...';
  codeContent.textContent = '';

  fetch(`/api/code/${problemName}/${className}`)
    .then(res => res.json())
    .then(data => {
      if (data.error) {
        codeContent.textContent = `Error: ${data.error}`;
        codeTitle.textContent = 'Error';
        return;
      }

      codeTitle.textContent = `${className}.java`;
      codeContent.textContent = data.code;

      // Highlight syntax
      document.querySelectorAll('#codeContent').forEach(block => {
        hljs.highlightElement(block);
      });

      // Show on mobile
      codePanel.classList.add('active');
      codeContainer.scrollTop = 0;

      currentProblem = { name: problemName, class: className, file: `${problemName}/${className}` };
    })
    .catch(err => {
      console.error('Error loading code:', err);
      codeTitle.textContent = 'Error';
      codeContent.textContent = `Failed to load code: ${err.message}`;
    });
}

function closeCodePanel() {
  const codeViewer = document.querySelector('.code-viewer');
  codeViewer.classList.remove('active');
}

function debounce(func, wait) {
  let timeout;
  return function executedFunction(...args) {
    const later = () => {
      clearTimeout(timeout);
      func(...args);
    };
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
  };
}

