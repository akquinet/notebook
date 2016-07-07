package de.akquinet.engineering.notebook.ui.auth;

import java.security.Principal;

/**
 * @author Axel Meier, akquinet engineering GmbH
 */
public class RolePrincipal implements Principal
{
    private String name;

    public RolePrincipal(final String name)
    {
        this.name = name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}