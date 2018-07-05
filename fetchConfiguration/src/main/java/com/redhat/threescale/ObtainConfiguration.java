package com.redhat.threescale;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import com.redhat.threescale.entities.Accounts;
import com.redhat.threescale.entities.Accounts.Account;

/**
 * @author <a href="mailto:jbutler@redhat.com">Joseph S. Butler</a>
 */
public class ObtainConfiguration {

	public static void main(final String[] args) throws Exception {
		
		// TODO
		// Add command line parameters for 3Scale URL + token

		// String threeScaleURL = null;

		// if (args.length != 1) {
		// throw new Exception("Format:\njava -jar obtainConfiguration.jar
		// <URL>");
		// }

		// threeScaleURL = args[0];

		// String url = null;

		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new ThreeScaleRouteBuilder("redhat-bcn-training",
				"3bcda06e7ea632a484ad6bf633cbdd75314f09bb108cb5701ac84826966ddf2e"));

		ProducerTemplate template = context.createProducerTemplate();

		context.start();

		Accounts accounts = template.requestBody("direct:obtainThreeScaleConfiguration", null, Accounts.class);
		
		// TODO
		// Now that we have a list of account, now look to populate a different 3Scale instance
		List<Account> accountList = accounts.getAccount();
		for (Account acct : accountList) {
			System.out.println("Id: " + acct.getId());
			
			// TODO
			// 
			
		}

	}

}