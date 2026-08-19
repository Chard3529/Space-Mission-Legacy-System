# Space Mission Kata

`SpaceMission` reads telemetry during a mission and logs it.

## Your task

Mission control now wants oxygen readings logged too. `TelemetryReading.type`
already anticipates `"OXYGEN"` (see the comment on the field), but
`SpaceMission.runMission()` doesn't have a case for it — right now an
oxygen reading falls into the `else` and gets logged as `Unknown reading`.

Add a case to `runMission()` that logs oxygen readings the same way the
existing ones are logged, e.g.:

```
Oxygen: 20.9 % at 1732000000000
```

That's it. That's the task.

## One thing to decide before you start editing

`runMission()` already has two similar cases in there (`TEMP`,
`PRESSURE`). You're about to add a third to the same method, in the same
class, that has never had a test written against it.

Before you touch it: how will you know your change didn't break the
existing TEMP/PRESSURE logging while you were in there? If your honest
answer is "I'll run it and read the output," sit with that for a second —
would that catch a regression next month, or in a PR review, or on a build
server?

Whatever you decide to do about that *is* the exercise. There's no
`src/test` file to nudge you either way — if you decide you want one,
that decision, and what happens when you try, is the point.

When you've either got a test in place or have a clear, specific reason you
couldn't get one, check out the `solution` branch. It maps what you ran
into to the exact technique from *Working Effectively with Legacy Code*
(Michael Feathers) that resolves it.
