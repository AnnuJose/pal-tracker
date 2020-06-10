package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    public Map<Long, TimeEntry> timeEntryMap = new HashMap<>();
    private long id = 1L;

    public TimeEntry create(TimeEntry timeEntry) {

        TimeEntry localTimeEntry = new TimeEntry(id, timeEntry.getProjectId(),
                timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());

        timeEntryMap.put(id, localTimeEntry);
        id++;
        return localTimeEntry;
    }

    public TimeEntry find(Long timeEntryId) {
        return timeEntryMap.get(timeEntryId);
    }


    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if(find(id)==null) return null;
        TimeEntry timeEntryRetrieved = new TimeEntry(id, timeEntry.getProjectId(),
                timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.replace(id,timeEntryRetrieved);
        return timeEntryRetrieved;
    }

    public void delete(Long id) {
        timeEntryMap.remove(id);

    }
}
