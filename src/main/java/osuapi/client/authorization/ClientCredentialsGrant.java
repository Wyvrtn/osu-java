package osuapi.client.authorization;

import java.time.OffsetDateTime;
import java.time.ZoneId;

import osuapi.client.core.AbstractApiAuthorization;
import osuapi.models.authorization.ClientCredentialsResponse;

public final class ClientCredentialsGrant extends AbstractApiAuthorization {
	
	public ClientCredentialsGrant(int clientId, String clientSecret) {
		this(Integer.toString(clientId), clientSecret);
	}
	
	public ClientCredentialsGrant(String clientId, String clientSecret) {
		super(ClientCredentialsGrant.class);
		authorizationBody.put("client_id", clientId);
		authorizationBody.put("client_secret", clientSecret);
		authorizationBody.put("grant_type", "client_credentials");
		authorizationBody.put("scope", "public");
		setStatus(true);
		LOG.info("New Instance of {} created in Thread {}", 
				this.getClass().getName(), Thread.currentThread().getName());
	}
	
	protected synchronized void authorizationFlow(AbstractOsuApiClientInternal svc) {
		String authBody = super.encodeFormUrl(authorizationBody);
		ClientCredentialsResponse apResponse = (ClientCredentialsResponse) svc.requestNewToken(authBody);
		apResponse.validation();
		setAccessToken(apResponse.getAccessToken());
		setExpirationDate(OffsetDateTime.now(ZoneId.systemDefault())
			.plusSeconds(apResponse.getExpiresIn() - 30L /** Leniency */));
		LOG.info(getAccessToken());
	}

	protected void refreshAccessToken(AbstractOsuApiClientInternal svc) {
		authorizationFlow(svc);
	}
}