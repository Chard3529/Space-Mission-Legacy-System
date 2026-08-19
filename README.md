# Space Mission Kata

`SpaceMission` reads telemetry during a mission and logs it. Mission control
wants to change how it logs readings, but nobody trusts the class enough to
touch it — there isn't a single test on it.

## Your task

Write a unit test for `SpaceMission.runMission()` that checks it logs a
temperature reading correctly. A stub is waiting for you at
[src/test/java/no/loopacademy/SpaceMissionTest.java](src/test/java/no/loopacademy/SpaceMissionTest.java).

**Rules for this pass:**

- Don't modify `SpaceMission`, `TelemetryClient`, `Config`, or
  `TelemetryReading` yet — production code is off limits for now. Just try
  to Arrange / Act / Assert.
- When something blocks you, write down *in your own words* what's actually
  stopping you before you look anywhere else. Naming the problem precisely
  is the point of this exercise, not just getting past it.

Run the test with:

```
./gradlew test
```

When you've named the problem — or given it a solid try and want to compare
notes — check out the `solution` branch. It has a table mapping each
problem you'll hit to the specific technique from *Working Effectively with
Legacy Code* (Michael Feathers) that fixes it; a copy of the book is in
[refs/](refs/) if you want to read the chapter behind a technique.
