package com.attila.logic.EventHandler;

public final class MoveEvent {
    private final EventSource eventSource;
    private final EventType eventType;

    public MoveEvent(EventSource eventSource, EventType eventType) {
        this.eventSource = eventSource;
        this.eventType = eventType;
    }

    public EventSource getEventSource() {
        return eventSource;
    }

    public EventType getEventType() {
        return eventType;
    }
}
