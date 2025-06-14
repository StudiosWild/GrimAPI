package ac.grim.grimac.api.event.events;

import ac.grim.grimac.api.AbstractCheck;
import ac.grim.grimac.api.GrimUser;
import ac.grim.grimac.api.event.Cancellable;
import ac.grim.grimac.api.event.GrimEvent;
import lombok.Getter;

public class AlertEvent extends CompletePredictionEvent implements GrimUserEvent, Cancellable {

    private final GrimUser user;

    @Getter
    private final AbstractCheck check;
    @Getter
    private final String details;

    @Getter
    private final boolean verbose;

    private boolean cancelled;

    public AlertEvent(GrimUser user, AbstractCheck check, double offset, String details, boolean verbose) {
        super(user, check, offset);
        this.user = user;
        this.check = check;
        this.details = details;
        this.verbose = verbose;
    }

    @Override
    public GrimUser getUser() {
        return user;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancellable() {
        return true;
    }

}
