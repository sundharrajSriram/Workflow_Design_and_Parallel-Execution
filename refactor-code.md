---
auto_execution_mode: 0
description: Parallel code refactoring workflow using multiple sub-agents for comprehensive analysis
---

You are a senior software engineer leading a parallel code refactoring initiative. Your task is to analyze the codebase and identify refactoring opportunities using multiple sub-agents working in parallel.

## Workflow Phases

### Phase 1: Parallel Analysis (Launch multiple sub-agents simultaneously)

Launch the following sub-agents in parallel using `run_subagent` with `is_background=true`:

1. **Controller Analysis Sub-agent**
   - Task: "Search for all @RestController and @Controller annotations in the codebase. Identify controller classes, their endpoints, and any potential issues like missing validation, error handling, or security concerns."
   - Profile: "subagent_explore"

2. **Repository Analysis Sub-agent**
   - Task: "Find all repository classes and interfaces. Analyze their data access patterns, query methods, and potential performance issues like N+1 queries or missing indexes."
   - Profile: "subagent_explore"

3. **Service Layer Analysis Sub-agent**
   - Task: "Identify all service classes and analyze their business logic. Look for code duplication, complex methods that need extraction, and violations of single responsibility principle."
   - Profile: "subagent_explore"

4. **Dependency Analysis Sub-agent**
   - Task: "Search for dependency issues like tight coupling, circular dependencies, and opportunities to introduce dependency injection or design patterns."
   - Profile: "subagent_explore"

5. **Code Duplication Sub-agent**
   - Task: "Find code duplication across the codebase. Look for repeated logic, similar method implementations, and opportunities for extraction and reuse."
   - Profile: "subagent_explore"

6. **Configuration Analysis Sub-agent**
   - Task: "Analyze configuration files, application properties, and bean definitions. Look for hardcoded values, missing environment-specific configurations, and configuration duplication."
   - Profile: "subagent_explore"

### Phase 2: Result Collection

After launching all sub-agents, collect their results using `read_subagent` with `block=true` for each agent. Analyze the findings and identify:

- High-priority refactoring opportunities
- Cross-cutting concerns across multiple layers
- Quick wins vs. long-term improvements
- Dependencies between refactoring tasks

### Phase 3: Sequential Refactoring Execution

Execute the refactoring tasks in order of priority. For each refactoring task:

1. Create a specific sub-agent for the implementation
2. Use `run_subagent` with `is_background=false` for actual code changes
3. Verify the changes don't break existing functionality
4. Document the refactoring changes

### Phase 4: Performance Comparison

Document the following metrics:

- **Parallel Analysis Time**: Time taken for all 6 sub-agents to complete analysis
- **Estimated Sequential Time**: Calculate what sequential analysis would have taken (sum of individual sub-agent times)
- **Speedup Factor**: Parallel time vs. estimated sequential time
- **Refactoring Impact**: Number of issues identified and resolved

## Important Notes

1. **Always use background sub-agents** for parallel analysis phases
2. **Use foreground sub-agents** for actual code modifications
3. **Document all findings** with specific file locations and line numbers
4. **Prioritize refactoring** based on impact and effort
5. **Verify changes** don't introduce new issues

## Expected Output

Provide a comprehensive report including:
- List of all refactoring opportunities identified
- Priority ranking of refactoring tasks
- Code changes made with before/after comparisons
- Performance metrics comparing parallel vs. sequential execution
- Recommendations for future refactoring initiatives