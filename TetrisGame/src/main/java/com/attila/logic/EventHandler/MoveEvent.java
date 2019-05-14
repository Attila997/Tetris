package com.attila.logic.EventHandler;

/**
 * Class for the move events.
 */
public final class MoveEvent {
    /**
     * Source of the event.
     */
    private final EventSource eventSource;
    /**
     * Source of the event.
     */
    private final EventType eventType;

    /**
     * Assignment constructor.
     * @param eventSource
     * @param eventType
     */
    public MoveEvent(EventSource eventSource, EventType eventType) {
        this.eventSource = eventSource;
        this.eventType = eventType;
    }

    /**
     * Getter for source of the event.
     * @return {@link EventSource}
     */
    public EventSource getEventSource() {
        return eventSource;
    }


    /**
     * Getter for type of the event.
     * @return {@link EventType}
     */
    public EventType getEventType() {
        return eventType;
    }
}
