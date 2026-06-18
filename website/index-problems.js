const fs = require('fs');
const path = require('path');

const ALGORITHMS_PATH = path.join(__dirname, '..', 'maven', 'src', 'main', 'Coding', 'Algorithms');
const OUTPUT_FILE = path.join(__dirname, 'problems.json');

function extractProblemInfo(filePath, fileName) {
  try {
    const content = fs.readFileSync(filePath, 'utf8');

    // Extract first 500 chars as preview (remove comments)
    let preview = content
      .split('\n')
      .filter(line => !line.trim().startsWith('//') && !line.trim().startsWith('*'))
      .join(' ')
      .substring(0, 300)
      .trim();

    return {
      preview: preview + '...'
    };
  } catch (e) {
    return { preview: 'Unable to read file' };
  }
}

function scanDirectory(dir, difficulty = 'Unknown') {
  const problems = [];

  try {
    const entries = fs.readdirSync(dir, { withFileTypes: true });

    for (const entry of entries) {
      const fullPath = path.join(dir, entry.name);

      if (entry.isDirectory()) {
        // Check if this directory contains Java files (problem folder)
        const javaFiles = fs.readdirSync(fullPath).filter(f => f.endsWith('.java'));

        if (javaFiles.length > 0) {
          // Extract problem ID from folder name (e.g., "LongestNiceSub_1763" → "1763")
          const problemMatch = entry.name.match(/_(\d+)$/);
          const problemId = problemMatch ? problemMatch[1] : 'N/A';

          // Scan all Java files in this problem folder
          for (const javaFile of javaFiles) {
            const javaFilePath = path.join(fullPath, javaFile);
            const fileInfo = extractProblemInfo(javaFilePath, javaFile);

            problems.push({
              name: entry.name,
              problemId: problemId,
              class: javaFile.replace('.java', ''),
              difficulty: difficulty,
              file: `${entry.name}/${javaFile}`,
              preview: fileInfo.preview
            });
          }
        }
      }
    }
  } catch (e) {
    console.error(`Error scanning ${dir}:`, e.message);
  }

  return problems;
}

function buildIndex() {
  console.log('Building index...');

  const allProblems = [];

  // Scan each difficulty level
  const difficulties = ['Hard', 'Medium', 'Normal'];

  for (const difficulty of difficulties) {
    const diffPath = path.join(ALGORITHMS_PATH, difficulty);
    if (fs.existsSync(diffPath)) {
      const problems = scanDirectory(diffPath, difficulty);
      allProblems.push(...problems);
      console.log(`  ${difficulty}: ${problems.length} solutions`);
    }
  }

  // Write index
  fs.writeFileSync(OUTPUT_FILE, JSON.stringify(allProblems, null, 2));
  console.log(`\n✓ Index built: ${allProblems.length} total solutions`);
  console.log(`✓ Written to: ${OUTPUT_FILE}`);

  return allProblems;
}

buildIndex();

