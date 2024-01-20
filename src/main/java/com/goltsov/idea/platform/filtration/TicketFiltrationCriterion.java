package com.goltsov.idea.platform.filtration;

import com.goltsov.idea.platform.model.Ticket;

import java.util.function.Predicate;

public interface TicketFiltrationCriterion {

    Predicate<Ticket> getPredicate();
}
