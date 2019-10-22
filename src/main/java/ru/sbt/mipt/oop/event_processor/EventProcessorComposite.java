package ru.sbt.mipt.oop.event_processor;

import java.util.ArrayList;
import java.util.List;

public class EventProcessorComposite {
    private List<EventProcessor> processors = new ArrayList<>();

    public void addProcessor(EventProcessor processor) {
        processors.add(processor);
    }

    public void removeProcessor(EventProcessor processor) {
        processors.remove(processor);
    }

    public List<EventProcessor> getProcessors() {
        return processors;
    }
}
