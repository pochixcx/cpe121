# Lecture 4: Design Thinking for Software Solutions

## Overview

This lecture introduces design thinking as a practical problem-solving approach for building software that people will actually use.

In many student projects, the team starts with screens, buttons, database tables, and code. That approach often produces a working system, but not always a useful one. Design thinking reverses that habit. It begins with people, their frustrations, their routines, and the real context of the problem before deciding what features to build.

For your PIT, this matters because you are not only required to create a Java desktop application. You are expected to create a solution to a real problem. A correct program that solves the wrong problem is still a weak project. A strong project connects user needs, system behavior, interface design, and implementation decisions.

This lecture focuses on how to use design thinking to:

- understand the real user problem,
- define a meaningful software opportunity,
- generate solution ideas,
- prototype and test before full implementation,
- translate insights into a Java desktop app design.

---

## Learning Outcomes

After this lecture, you should be able to:

1. Explain design thinking and why it is useful in software development.
2. Distinguish problem-focused thinking from solution-first thinking.
3. Apply the five stages of design thinking to a software project.
4. Gather user insights using empathy-based techniques.
5. Write a clear problem statement and `How Might We` questions.
6. Generate and evaluate solution ideas for a Java desktop application.
7. Build low-fidelity and software-oriented prototypes before coding.
8. Test a proposed solution using feedback from target users.
9. Connect design thinking outputs to system features, UI design, and implementation planning.

---

## 1. What Is Design Thinking?

Design thinking is a human-centered, iterative approach to solving problems.

Human-centered means the process starts with the people affected by the problem.

Iterative means you do not assume your first idea is correct. You explore, test, revise, and improve.

Problem-solving means the goal is not to produce attractive screens or many features. The goal is to create a solution that improves a real situation.

In software development, design thinking helps teams avoid these common mistakes:

- building features nobody needs,
- copying systems without understanding the local context,
- focusing only on technical difficulty instead of user value,
- creating confusing workflows for end users,
- discovering major requirement problems too late.

### Simple definition

Design thinking is a structured way of asking:

`Who is experiencing the problem?`

`What is really making the situation difficult?`

`What kind of solution would help them most?`

`How can we test that idea quickly before fully building it?`

---

## 2. Why Design Thinking Matters in Software

Software is often treated as if the main challenge is programming. Programming is important, but it is only one part of solution-building.

Before writing code, a team must answer deeper questions:

- What exact problem are we solving?
- Who experiences it most often?
- What do users currently do instead?
- Why do existing methods fail?
- What would success look like for the user?

If those questions are weakly answered, even a technically correct application may fail.

### Analogy: Building a Bridge

Imagine being told to build a bridge.

If you immediately buy cement and start construction, you may end up building:

- in the wrong location,
- for the wrong number of people,
- with the wrong materials,
- for a problem that never required a bridge.

Maybe the real issue was not crossing a river. Maybe the issue was an unsafe road, poor traffic flow, or lack of transport scheduling.

Software works the same way.

Jumping directly to coding is like pouring concrete before understanding the terrain.

### Analogy: Prescribing Medicine

A doctor does not begin by handing out random medicine. The doctor first listens, checks symptoms, investigates causes, and then prescribes treatment.

Design thinking follows the same logic:

- empathy is diagnosis,
- definition is identifying the illness clearly,
- ideation is exploring treatment options,
- prototyping is trying a safe early version,
- testing is checking if the treatment actually helps.

---

## 3. Design Thinking vs Solution-First Thinking

### Solution-First Thinking

This is the usual beginner approach:

1. Think of an app idea.
2. Add screens and features.
3. Start coding.
4. Ask later whether the system is actually needed.

Example:

`Let's build an enrollment app.`

That sounds productive, but it skips important questions:

- What exactly is difficult in the current enrollment process?
- Is the delay caused by paperwork, missing records, poor communication, or schedule conflicts?
- Who suffers most: students, staff, or faculty?
- Does a desktop app solve the real pain point?

### Design Thinking

This approach begins differently:

1. Observe the current situation.
2. Talk to users.
3. Identify pain points.
4. Define the real problem.
5. Generate possible solutions.
6. Prototype and test.
7. Build the most promising version.

Example:

`Students spend too much time waiting because advising records are stored in separate notebooks and staff must manually verify prerequisites.`

That statement is much stronger because it describes:

- the user,
- the pain point,
- the context,
- the actual cause.

Now software decisions become more meaningful.

---

## 4. The Five Stages of Design Thinking

The five stages are:

1. Empathize
2. Define
3. Ideate
4. Prototype
5. Test

These are not always strictly linear. Teams often go back to earlier stages after learning something new.

### 4.1 Empathize

Empathize means understanding users, not assuming what they need.

You collect information about:

- what users do,
- what they struggle with,
- what they feel,
- what they avoid,
- what slows them down,
- what a better experience would mean for them.

In a PIT software project, users may include:

- students,
- teachers,
- staff,
- small business owners,
- clinic personnel,
- librarians,
- organization officers.

#### Questions to ask during empathy work

- What tasks do you do repeatedly?
- Which part is most frustrating?
- What mistakes happen often?
- What takes too much time?
- What information is hard to find?
- What do you do when the current process fails?

#### Real-world scenario

Suppose your PIT is about a barangay health center.

The team initially plans to build a `patient record system`.

After interviews and observation, they discover the bigger issue is not only record storage. The real pain points are:

- nurses rewrite the same patient details multiple times,
- patients wait longer because previous visit information is difficult to retrieve,
- monthly reports are manually counted from paper logs,
- staff feel stressed during peak hours because information is scattered.

This is a much richer understanding than simply saying `we need a system`.

### 4.2 Define

Define means converting raw observations into a clear and focused problem statement.

At this stage, you answer:

`What exact problem should we solve first?`

A strong problem statement is:

- specific,
- human-centered,
- insight-based,
- actionable.

#### Weak problem statement

`The clinic needs a system.`

This is too broad and not insightful.

#### Better problem statement

`Clinic staff need a faster way to retrieve patient visit history because repeated manual searching delays service and increases reporting errors.`

This version identifies:

- the user: clinic staff,
- the need: faster retrieval,
- the reason: delays and reporting errors.

#### How Might We questions

After defining the problem, teams often use `How Might We` questions.

Examples:

- How might we help clinic staff retrieve patient records within seconds?
- How might we reduce repeated writing of patient information?
- How might we generate monthly summaries without manual counting?

These questions are useful because they are focused without locking the team into one solution too early.

### 4.3 Ideate

Ideate means generating many possible solutions before choosing one.

The goal is not to find the perfect idea immediately. The goal is to expand the range of possibilities.

During ideation, avoid saying `that won't work` too early. Early judgment can kill useful ideas before they are explored.

#### Common ideation techniques

- brainstorming,
- mind mapping,
- `crazy 8s` sketching,
- role-based thinking: `What would the cashier need? What would the admin need?`,
- worst idea exercise: intentionally suggest bad ideas to discover hidden assumptions.

#### Example for a library PIT

Problem:

`Students waste time checking if books are available.`

Possible ideas:

- searchable desktop catalog,
- barcode-based check-in/check-out,
- quick title filtering by category,
- overdue reminders for staff dashboard,
- borrowing history per student,
- kiosk-style lookup screen near the entrance.

The key lesson is that the first idea is not automatically the best idea.

### 4.4 Prototype

Prototype means building a small, fast, low-risk version of the idea.

A prototype is not the final product. It is a thinking tool.

In software, prototypes can be:

- hand-drawn screen sketches,
- paper workflows,
- wireframes,
- clickable mockups,
- partial Swing forms,
- sample database records,
- a very limited proof of concept.

#### Why prototypes matter

They help you discover:

- unclear workflows,
- unnecessary features,
- confusing labels,
- missing user steps,
- poor assumptions.

#### Analogy: Recipe Tasting

A cook does not prepare 500 servings of a new recipe without tasting a small batch first.

A prototype is that small batch.

You test early so that mistakes are cheap.

### 4.5 Test

Test means showing the prototype to users and learning from their reactions.

The purpose is not to defend your design. The purpose is to discover what is wrong, confusing, incomplete, or unexpectedly helpful.

Useful testing questions include:

- What do you think this screen does?
- What would you click first?
- Was anything confusing?
- What information is missing?
- Would this actually help in your real workflow?
- Which part still feels slow or difficult?

Testing often reveals that:

- labels are unclear,
- the order of steps is wrong,
- users need fewer fields,
- users need more context,
- the app solves only part of the real problem.

That is not failure. That is the reason testing exists.

---

## 5. Design Thinking Applied to a Java Desktop App PIT

Your PIT requires building a Java desktop application. Design thinking helps you decide what that application should do and how it should behave.

### From problem insight to software feature

| Design Thinking Output | Software Translation               |
| ---------------------- | ---------------------------------- |
| User pain point        | Required feature or workflow       |
| Observation notes      | Business rules and edge cases      |
| Problem statement      | Core system purpose                |
| Persona or user role   | Access level and interface needs   |
| User journey           | Screen flow and navigation         |
| Prototype feedback     | UI revision and feature refinement |

### Example: School Clinic Desktop App

#### Empathize

The team observes the clinic and interviews the nurse.

Findings:

- patient logs are written on paper,
- repeat visits are hard to trace,
- medicine inventory is not updated consistently,
- end-of-month reporting is exhausting.

#### Define

Problem statement:

`School clinic staff need a faster and more reliable way to record visits, retrieve patient history, and prepare reports because the current paper-based process causes delays and missing information.`

#### Ideate

Possible solution ideas:

- patient registration module,
- visit history search,
- medicine inventory panel,
- automatic monthly report generation,
- alert for low-stock medicine.

#### Prototype

The team sketches:

- login window,
- patient form,
- visit log table,
- monthly report preview.

Then they build a partial Swing prototype with:

- `JFrame` main window,
- `JTabbedPane` for records and inventory,
- `JTable` for visit history,
- simple search field.

#### Test

The nurse responds:

- the search bar should appear on the main screen,
- age is less useful than birthdate,
- common illnesses should use a dropdown,
- the report needs totals by date range.

This feedback improves the final implementation.

Without design thinking, the team might have built a generic record system that looked complete but still wasted the nurse's time.

---

## 6. Empathy Tools You Can Use for PIT

You do not need expensive research tools. You need disciplined observation and good questions.

### 6.1 Interviews

Talk directly to target users.

Use open-ended questions. Avoid questions that can be answered by only `yes` or `no`.

Better questions:

- Walk me through your current process.
- Which part takes the most time?
- What mistakes happen often?
- What do you do when information is missing?

Avoid leading questions such as:

- You want a desktop app, right?
- Wouldn't automation solve this?

These questions push users toward your assumption.

### 6.2 Observation

Watch the real workflow.

Users sometimes describe their work differently from how it actually happens. Observation helps uncover:

- repeated steps,
- workarounds,
- delays,
- interruptions,
- missing resources.

### 6.3 Empathy Map

An empathy map helps organize findings into four areas:

- says,
- thinks,
- does,
- feels.

Example for a registrar staff member:

- says: `Students keep asking the same schedule questions.`
- thinks: `I might miss a record when the line is long.`
- does: checks paper files and multiple forms.
- feels: pressured and rushed.

This creates richer understanding than a plain feature list.

### 6.4 User Journey Map

A user journey map describes each step a person goes through while completing a task.

Example: borrowing a book in a small library.

1. Student asks if a book is available.
2. Staff checks notebook or shelves.
3. Staff verifies borrower details.
4. Staff writes transaction manually.
5. Student receives the book.

From this sequence, you can identify where software can help most.

---

## 7. Writing a Strong Problem Statement

A strong problem statement keeps your team focused.

Use this structure:

`[User] needs [need] because [insight or pain point].`

Examples:

- `Library staff need a faster way to track borrowed books because manual recording causes delays and misplaced entries.`
- `Student organization officers need a clearer attendance process because paper logs make it hard to produce accurate participation records.`
- `Clinic staff need instant access to previous patient visits because manual logbooks slow down service during busy periods.`

### Common mistakes in problem statements

- Naming the solution too early.
- Being too broad.
- Ignoring the real user.
- Describing a symptom without cause.

Weak:

`We need to make a system with login, dashboard, and reports.`

Better:

`Organization officers need a reliable attendance tracking process because handwritten records are difficult to verify and summarize after events.`

---

## 8. Ideation for Software Projects

After defining the problem clearly, the team explores possible solutions.

### Useful rule

Separate idea generation from idea evaluation.

First, create many ideas.

Then, evaluate them using criteria such as:

- usefulness,
- feasibility,
- simplicity,
- time to implement,
- fit with your target users,
- fit with Java desktop app constraints.

### Example evaluation table

| Idea                   | User Value | Difficulty | Priority |
| ---------------------- | ---------- | ---------- | -------- |
| Searchable records     | High       | Medium     | High     |
| Dark mode theme        | Low        | Low        | Low      |
| Auto-generated reports | High       | Medium     | High     |
| Animated dashboard     | Low        | Medium     | Low      |

This helps the team avoid spending time on attractive but low-value features.

### Important reminder

In student software projects, extra features do not automatically mean better design.

Good design means:

- the right features,
- for the right users,
- in the right order,
- with the right level of simplicity.

---

## 9. Prototyping in a Software Context

Many students think a prototype must already be coded. That is not required.

You can prototype at several levels.

### Level 1: Paper Prototype

Draw the screens and user flow by hand.

Use this to test:

- layout,
- labels,
- sequence of actions,
- missing information.

### Level 2: Wireframe Prototype

Create cleaner digital screen layouts without full functionality.

Use this to test:

- navigation,
- grouping of controls,
- readability,
- workflow clarity.

### Level 3: Technical Prototype

Build a limited Java Swing version with a few working parts.

For example:

- a form that accepts input,
- a `JTable` showing sample records,
- buttons for add, search, and clear,
- mock data without full database integration.

This is useful when testing:

- field arrangement,
- user interaction speed,
- validation flow,
- visibility of important actions.

### Pitfall to avoid

Do not overbuild the prototype.

If you spend too much time polishing the prototype, the team may become afraid to change it after feedback.

---

## 10. Testing and Iteration

Testing should answer one question:

`Does this solution improve the user's experience in a meaningful way?`

### What to look for during testing

- hesitation,
- confusion,
- repeated clicks,
- incorrect interpretation,
- skipped fields,
- comments like `I thought this button would do something else.`

### Good mindset during testing

If users struggle, do not blame the user.

Assume the design needs improvement.

### Example test result

Prototype feedback for a small store inventory app:

- staff do not use product codes often,
- they search by product name instead,
- they need stock warning colors,
- they want sales summary by day.

Resulting design changes:

- move search field to the top,
- prioritize product name input,
- add low-stock visual indicator,
- add date-based summary report.

This is how testing shapes better software.

---

## 11. Real-World Case Discussion

### Case: Manual Attendance Tracking for Student Events

A student organization uses paper attendance sheets during seminars and meetings.

#### Current problems

- handwriting is hard to read,
- duplicate entries happen,
- officers spend hours summarizing attendance,
- some students question whether they were marked present.

#### Wrong approach

The team says:

`Let's build a modern dashboard with multiple themes, charts, and profile cards.`

This sounds impressive but does not start from the core pain point.

#### Design thinking approach

Empathize:

- interview officers,
- observe event check-in,
- inspect current logs.

Define:

`Organization officers need a faster and more reliable attendance process because paper-based recording leads to unreadable entries, duplicate records, and slow post-event reporting.`

Ideate:

- searchable member list,
- quick attendance marking,
- duplicate detection,
- event-based summary report,
- exportable attendance log.

Prototype:

- login form,
- event selection screen,
- attendance table,
- summary report preview.

Test:

- officers ask for a late-arrival status,
- they want a search box by student number,
- they prefer one-click attendance marking.

Final result:

The Java desktop app becomes simpler, more relevant, and easier to defend during presentation because every major feature is clearly tied to observed user needs.

---

## 12. Connecting Design Thinking to System Design

Design thinking does not replace software engineering. It improves software engineering by making the requirements more meaningful.

Once your team finishes early design thinking work, you can convert the results into technical artifacts.

### Example translation

| Design Insight                      | Software Artifact                    |
| ----------------------------------- | ------------------------------------ |
| Users need separate access levels   | role-based login                     |
| Users often search previous records | search module                        |
| Reports are manually summarized     | reporting feature                    |
| Repeated fields slow down encoding  | reusable form fields and dropdowns   |
| Users forget where to click next    | clearer navigation and button labels |

### From design thinking to coding tasks

You can translate outcomes into:

- use cases,
- feature lists,
- screen sketches,
- database entities,
- validation rules,
- class responsibilities.

Example:

If testing shows users frequently search by student number, then your implementation may include:

- a search text field,
- a button event handler,
- a database query,
- a table refresh function.

The code exists because of a validated user need, not because it seemed technically interesting.

---

## 13. Common Mistakes Students Make

### Mistake 1: Starting with the title only

Example:

`Inventory System`

A title is not a problem statement.

### Mistake 2: Assuming users need what the team wants to build

Do not confuse your preferred solution with the user's actual need.

### Mistake 3: Collecting opinions but not observing the workflow

Interviews alone are useful, but observation often reveals the hidden problems.

### Mistake 4: Adding too many features

Feature overload can make a desktop application harder to use and harder to finish.

### Mistake 5: Ignoring feedback because coding already started

This is exactly why prototyping and early testing matter.

### Mistake 6: Treating design thinking as separate from implementation

Design thinking should shape the structure of the software, not remain as a report section only.

---

## 14. Practical Framework for Your PIT Team

Use this simplified process for your project.

### Step 1: Identify a real environment

Choose a setting with a clear process problem:

- clinic,
- library,
- office,
- small store,
- school department,
- student organization.

### Step 2: Meet or observe real users

Gather specific evidence, not guesses.

### Step 3: Write the problem statement

Use the format:

`[User] needs [need] because [reason].`

### Step 4: Create `How Might We` questions

Generate focused opportunity questions.

### Step 5: Brainstorm software ideas

List multiple possible features or workflows.

### Step 6: Prioritize high-value features

Pick features that strongly reduce pain points and are feasible within the course timeline.

### Step 7: Sketch the app before coding

Plan the screens, flow, and user actions.

### Step 8: Test with users

Let real or representative users react to the design.

### Step 9: Revise before full implementation

Fix the design while changes are still cheap.

### Step 10: Build the Java desktop app

Only after problem understanding, feature prioritization, and prototype feedback are strong.

---

## 15. Reflection Questions

Use these to evaluate your PIT idea:

1. Who exactly are the users of our system?
2. What is the current process they follow?
3. What part of the process causes the most frustration?
4. What evidence do we have that this problem is real?
5. Are we solving a root problem or only a surface symptom?
6. Which software features directly address the pain point?
7. Which features are unnecessary for the first version?
8. How will we test whether our proposed app actually helps?

---

## 16. Summary

Design thinking is not just for product designers. It is highly relevant to software developers because software should solve real human problems, not just demonstrate technical effort.

For your PIT, design thinking helps your team:

- understand the users,
- define the correct problem,
- generate better solution ideas,
- prototype before overcommitting,
- test and improve the design,
- justify why your Java desktop application deserves to be built.

The strongest software projects are not those with the most features. They are the ones with the clearest connection between user pain points and system behavior.

In short:

`Good coding builds software correctly.`

`Good design thinking ensures you are building the correct software.`

---

### Activity 1: Suggested Format for PIT Problem Discovery Canvas

Objective:

Clarify the real-world problem behind your Java desktop app.

1. Describe the real-world context of the PIT.
2. Identify the target user and current manual workflow.
3. Write a user-centered problem statement.
4. Create `How Might We` questions.

## Part A: PIT Context and Users

### 1. Working PIT Title

Write the current title or working name of your proposed system.

Answer:

................................................................................

### 2. Target Users

Identify the main users of the system.

Guide questions:

- Who will directly use the application?
- Who experiences the problem most often?
- Who benefits if the workflow improves?

Answer:

................................................................................

................................................................................

### 3. Current Manual Process

Describe how the task is currently done without your system.

Answer:

................................................................................

................................................................................

................................................................................

---

## Part B: Pain Points and Initial Evidence

### 4. Main Pain Points

List at least three pain points in the current process.

| Pain Point | Why It Matters |
| ---------- | -------------- |
| 1.         |                |
| 2.         |                |
| 3.         |                |

### 5. Initial Evidence or Justification

Write the basis for your claim that this is a real problem.

If interviews are not yet possible, write your best initial justification and mark it as something to validate later.

Possible sources:

- observation,
- interview,
- repeated complaints,
- slow workflow,
- record errors,
- missing information,
- manual summarization.
- existing forms or records,
- team knowledge of the process,
- public or institutional information.

Answer:

................................................................................

................................................................................

---

## Part C: Problem Definition

### 6. User-Centered Problem Statement

Use this format:

`[User] needs [need] because [reason].`

Answer:

................................................................................

### 7. `How Might We` Questions

Write three `How Might We` questions based on your problem statement.

1. .............................................................................
2. .............................................................................
3. .............................................................................

### 8. Why Should This Be Solved Using Software?

Write 2-3 sentences explaining why a Java desktop app is an appropriate response to this problem.

Answer:

................................................................................

................................................................................

---

## Part D: Feature Prioritization

### 9. Map Pain Points to Features

List software features that directly respond to the identified pain points.

| Pain Point | Proposed Software Feature | Priority            |
| ---------- | ------------------------- | ------------------- |
|            |                           | High / Medium / Low |
|            |                           | High / Medium / Low |
|            |                           | High / Medium / Low |
|            |                           | High / Medium / Low |
|            |                           | High / Medium / Low |

### 10. First Version Scope

Identify the top three features that must be included in the first working version of the app.

1. .............................................................................
2. .............................................................................
3. .............................................................................

Explain briefly why these were prioritized.

................................................................................

................................................................................

---
