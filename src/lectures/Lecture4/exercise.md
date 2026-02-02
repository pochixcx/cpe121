## Objective

Create a Java program that determines a customer’s loan eligibility and loan amount based on a set of rules. The program must follow the rules exactly and in the correct order.

### Required Inputs

Your program must use the following variables:

```java
int income;
int creditScore;
boolean isEmployed;
```

**_This values must come from user input_**

Rules (Must Be Applied in This Order)

1. Income Validation
   - If income is less than 0, print:

   ```
   INVALID INCOME
   ```

   - Stop processing immediately.

2. Credit Score Check
   - If creditScore is less than 600, print:

   ```
   Not eligible
   ```

   - Stop processing immediately.

3. Income Eligibility
   - If income is less than 10,000, print:

   ```
   Not eligible
   ```

   - Stop processing immediately.

4. Determine Base Loan Amount
   - 10,000 – 19,999 → 50,000

   - 20,000 – 49,999 → 150,000

   - 50,000 and above → 300,000

5. Employment Override
   - If isEmployed is false, the loan amount must be capped at 50,000, even if the income qualifies for more.

6. Final Output

   Print exactly one line:

   ```
   Loan Amount: <amount>
   ```

   _Example Cases_
   | Income | Credit Score | Employed | Output |
   | ------ | ------------ | -------- | -------------------- |
   | -5000 | 700 | true | INVALID INCOME |
   | 8000 | 720 | true | Not eligible |
   | 15000 | 580 | true | Not eligible |
   | 15000 | 650 | false | Loan Amount: 50,000 |
   | 60000 | 700 | false | Loan Amount: 50,000 |
   | 60000 | 700 | true | Loan Amount: 300,000 |

## Grading Criteria

| Criterion             | Weight |
| --------------------- | ------ |
| Correct rule ordering | 40%    |
| Logic clarity         | 25%    |
| Constraint compliance | 20%    |
| Code readability      | 15%    |
