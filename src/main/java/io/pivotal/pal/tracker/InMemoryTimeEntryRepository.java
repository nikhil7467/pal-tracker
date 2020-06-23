package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    HashMap<Long,TimeEntry> inMemoryDBObject = new HashMap<>();
    long counter = 0;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(++counter);
        inMemoryDBObject.put(timeEntry.getId(),timeEntry);
        return inMemoryDBObject.get(timeEntry.getId());
    }

    @Override
    public TimeEntry find(Long id) {
        return inMemoryDBObject.get(id);
    }

    @Override
    public List<TimeEntry> list() {

        return new ArrayList<TimeEntry>(inMemoryDBObject.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if(inMemoryDBObject.containsKey(id))
        {
            timeEntry.setId(id);
            inMemoryDBObject.put(timeEntry.getId(),timeEntry);
        }
        return inMemoryDBObject.get(id);
    }

    @Override
    public void delete(Long id) {

        inMemoryDBObject.remove(id);
    }
}
