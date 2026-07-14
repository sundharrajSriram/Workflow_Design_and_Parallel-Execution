# Sample Refactor Project

This project demonstrates common code issues that can be identified and fixed using the parallel refactoring workflow.

## Project Structure

```
src/main/java/com/example/eligibility/
├── config/
│   └── RestTemplateConfig.java
├── controller/
│   └── EligibilityController.java
├── model/
│   ├── Customer.java
│   └── LoanProduct.java
├── repository/
│   ├── CustomerRepository.java
│   └── LoanProductRepository.java
└── service/
    ├── CustomerDataService.java
    └── LoanProductDataService.java
```

## Known Refactoring Opportunities

### 1. RestTemplate Duplication (High Priority)
- **Location**: `EligibilityController.java`
- **Issue**: Multiple `new RestTemplate()` instantiations throughout the controller
- **Impact**: Resource inefficiency, not using configured bean
- **Solution**: Inject `RestTemplate` via `@Autowired` from `RestTemplateConfig`

### 2. Code Duplication (Medium Priority)
- **Location**: `CustomerDataService.java` and `LoanProductDataService.java`
- **Issue**: Identical `validateEmail()` and `validateIncome()` methods in both services
- **Impact**: Maintenance burden, inconsistency risk
- **Solution**: Extract to a common `ValidationUtil` class

### 3. Repository Pattern Duplication (Low Priority)
- **Location**: `CustomerRepository.java` and `LoanProductRepository.java`
- **Issue**: Nearly identical CRUD operations
- **Impact**: Code repetition
- **Solution**: Create a generic `BaseRepository` interface

### 4. Exception Handling Issues (Medium Priority)
- **Location**: `EligibilityController.java`
- **Issue**: Generic exception handling with silent failures
- **Impact**: Poor error reporting, debugging difficulties
- **Solution**: Implement proper exception handling with specific error responses

### 5. Validation Logic Placement (Low Priority)
- **Location**: Service classes
- **Issue**: Business validation mixed with data access logic
- **Impact**: Separation of concerns violation
- **Solution**: Create separate validation layer

## Usage with Refactor Workflow

This project is designed to be used with the `refactor-code.md` workflow to demonstrate:

1. **Parallel Analysis**: Multiple sub-agents analyze different aspects simultaneously
2. **Issue Identification**: Comprehensive detection of refactoring opportunities
3. **Prioritized Refactoring**: Systematic approach to fixing issues
4. **Performance Comparison**: Measure parallel vs. sequential execution benefits

## Expected Workflow Results

When running the refactor-code workflow on this project, it should identify:

- 6+ sub-agents running in parallel during analysis phase
- 5+ refactoring opportunities with priority rankings
- 3-5x speedup compared to sequential analysis
- Specific file locations and line numbers for each issue