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

Or is it....😅
