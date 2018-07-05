package com.redhat.threescale;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;

public class ThreeScaleRouteBuilder extends RouteBuilder {

	private final static String SAAS_URL = "-admin.3scale.net";

	private final String urlString;

	public ThreeScaleRouteBuilder(final String threeScaleAccount, final String accessToken) {
		this.urlString = "https4://" + threeScaleAccount + SAAS_URL + "/admin/api/accounts.xml?access_token=" + accessToken;
	}

	@Override
	public void configure() throws Exception {
		
		JaxbDataFormat df = new JaxbDataFormat();
		df.setContextPath("com.redhat.threescale.entities");
	
		onException(Exception.class)
			.handled(true)
			.log("This is the exception: ${exception.message}");

		from("direct:obtainThreeScaleConfiguration")
			.routeId("ObtainConfigurationFromHttp")
			.log("Invoke HTTP Address")
			.to(urlString)
			.unmarshal(df)
			.log("Objects? ${body}");

	}

}