package org.pac4j.demo.j2e;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.logout.GoogleLogoutActionBuilder;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.oidc.client.OidcClient;
import org.pac4j.oidc.config.OidcConfiguration;
import org.pac4j.oidc.profile.OidcProfileDefinition;
import org.pac4j.oidc.profile.creator.OidcProfileCreator;

public class Auth0OIDCClient extends OidcClient<Auth0OIDCProfile> {
    public Auth0OIDCClient() {
    }

    public Auth0OIDCClient(OidcConfiguration configuration) {
        super(configuration);
    }

    protected void clientInit(WebContext context) {
        CommonHelper.assertNotNull("configuration", this.getConfiguration());
        this.getConfiguration().defaultDiscoveryURI("https://tenant1-cloud.eu.auth0.com/.well-known/openid-configuration");
        OidcProfileCreator profileCreator = new OidcProfileCreator(this.getConfiguration());
        profileCreator.setProfileDefinition(new OidcProfileDefinition((x) -> new Auth0OIDCProfile()));
        this.defaultProfileCreator(profileCreator);
        this.defaultLogoutActionBuilder(new GoogleLogoutActionBuilder());
        super.clientInit(context);
    }
}
