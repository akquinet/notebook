/*
 * WEAT EABR
 */
package de.akquinet.engineering.notebook.ui.i18n;

import javax.enterprise.context.ApplicationScoped;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Axel Meier, akquinet engineering GmbH
 */
@ApplicationScoped
public class MessageBundles
{
    private static final String BASE_NAME = "messages";

    private final Map<Locale, ResourceBundle> bundleMap = new HashMap<>();

    public MessageBundles()
    {
        bundleMap.put(Locale.US, ResourceBundle.getBundle(BASE_NAME, Locale.US));
        bundleMap.put(Locale.GERMANY, ResourceBundle.getBundle(BASE_NAME, Locale.GERMANY));
    }

    public ResourceBundle getBundle(final Locale locale){
        final ResourceBundle bundle = bundleMap.get(locale);
        return bundle != null ? bundle : bundleMap.get(Locale.US);
    }

    public String get(final Locale locale, final String key){
        return getBundle(locale).getString(key);
    }

    public String get(final Locale locale, final String key, final Object... params){
        final MessageFormat messageFormat = new MessageFormat(get(locale, key), locale);
        return messageFormat.format(params);
    }
}
