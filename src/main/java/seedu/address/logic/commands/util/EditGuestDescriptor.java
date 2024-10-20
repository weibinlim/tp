package seedu.address.logic.commands.util;

import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Rsvp;

/**
 * Stores the details to edit the guest with. Each non-empty field value will replace the
 * corresponding field value of the guest.
 */
public class EditGuestDescriptor extends EditPersonDescriptor {
    private Rsvp rsvp;

    public EditGuestDescriptor() {

    }

    /**
     * Copy constructor.
     * A defensive copy of {@code tags} is used internally.
     */
    public EditGuestDescriptor(EditGuestDescriptor toCopy) {
        super(toCopy);
        setRsvp(toCopy.rsvp);
    }

    /**
     * Returns true if at least one field is edited.
     */
    @Override
    public boolean isAnyFieldEdited() {
        return super.isAnyFieldEdited() || CollectionUtil.isAnyNonNull(rsvp);
    }

    public void setRsvp(Rsvp rsvp) {
        this.rsvp = rsvp;
    }

    public Optional<Rsvp> getRsvp() {
        return Optional.ofNullable(rsvp);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditGuestDescriptor)) {
            return false;
        }

        EditGuestDescriptor otherEditGuestDescriptor = (EditGuestDescriptor) other;
        return super.equals(other)
                && Objects.equals(rsvp, otherEditGuestDescriptor.rsvp);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", getName().orElse(null))
                .add("phone", getPhone().orElse(null))
                .add("email", getEmail().orElse(null))
                .add("address", getAddress().orElse(null))
                .add("tags", getTags().orElse(null))
                .add("RSVP", rsvp)
                .toString();
    }
}
