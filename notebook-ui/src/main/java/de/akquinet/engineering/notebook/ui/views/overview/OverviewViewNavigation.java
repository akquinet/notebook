package de.akquinet.engineering.notebook.ui.views.overview;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;

import javax.inject.Inject;

/**
 * @author Axel Meier, akquinet engineering GmbH
 */
@CDIView(OverviewViewNavigation.VIEW_NAME)
public class OverviewViewNavigation implements View, de.akquinet.engineering.notebook.ui.View
{
    public static final String VIEW_NAME = "overview";

    @Inject
    private OverviewView view;

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent)
    {
        view.onEnter();
    }

    @Override
    public <C> C getComponent(final Class<C> type)
    {
        return view.getComponent(type);
    }
}
