package org.pac4j.demo.j2e;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.logout.LogoutActionBuilder;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.redirect.RedirectAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Auth0LogoutActionBuilder<U extends CommonProfile> implements LogoutActionBuilder<U> {

    private static final Logger logger = LoggerFactory.getLogger(org.pac4j.core.logout.GoogleLogoutActionBuilder.class);

    @Override
    public RedirectAction getLogoutAction(final WebContext context, final U currentProfile, final String targetUrl) {

        final String redirectUrl = "https://tenant1-cloud.eu.auth0.com/v2/logout";
        logger.debug("redirectUrl: {}", redirectUrl);
        return RedirectAction.redirect(redirectUrl);
    }
}
