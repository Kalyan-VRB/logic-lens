import os


def create_problem_files(problem_name):
    # Normalize names
    file_prefix = problem_name.strip()
    dir_name = file_prefix.lower()

    # File names
    java_file = f"{file_prefix}.java"
    test_file = f"{file_prefix}Test.java"
    solution_md = f"{file_prefix}Solution.md"
    problem_md = f"{file_prefix}.md"

    # Create lowercase directory
    os.makedirs(dir_name, exist_ok=True)

    # Related Resources section for problem.md
    related_resources = f"""
---

## 🔗 Related Resources

- [Solution Explanation]({solution_md})
- [Java Code]({java_file})
- [Test Cases]({test_file})

---
"""

    # Files to create with content
    files_to_create = {
        java_file: f"// Java implementation for {file_prefix}\n\npublic class {file_prefix} {{\n\n}}",
        test_file: f"// Test cases for {file_prefix}\n\npublic class {file_prefix}Test {{\n\n}}",
        solution_md: f"# {file_prefix} – Solution Explanation\n\n## Problem Summary\n\n...",
        problem_md: f"# {file_prefix}\n\n## Problem Statement\n\n...{related_resources}"
    }

    for filename, content in files_to_create.items():
        file_path = os.path.join(dir_name, filename)
        with open(file_path, 'w') as f:
            f.write(content)

    print(f"All files created under ./{dir_name}/")


# Run
if __name__ == "__main__":
    problem_input = input("Enter problem name: ").strip()
    create_problem_files(problem_input)
