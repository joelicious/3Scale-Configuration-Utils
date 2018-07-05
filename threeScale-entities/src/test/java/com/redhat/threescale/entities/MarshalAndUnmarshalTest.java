package com.redhat.threescale.entities;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.redhat.threescale.entities.Accounts.Account;
import com.redhat.threescale.entities.PlansType.Plan;
import com.redhat.threescale.entities.UsersType.User;

public class MarshalAndUnmarshalTest {

	@Test
	public void marshalTest() throws JAXBException {

		Plan plan = new Plan();
		plan.setCostPerMonth(1223);
		plan.setName("name");
		plan.setState("state");

		PlansType planType = new PlansType();
		List<Plan> planList = planType.getPlan();
		planList.add(plan);

		UsersType userType = new UsersType();
		User user = new User();
		user.setEmail("email");
		userType.setUser(user);

		Account account = new Account();
		account.setExtraFields("extraFields");
		account.setUsers(userType);
		account.setPlans(planType);

		Accounts accounts = new Accounts();
		List<Account> accountList = accounts.getAccount();
		accountList.add(account);

		JAXBContext context = JAXBContext.newInstance(Accounts.class);
		final Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(accounts, System.out);

	}

	@Test
	public void unmarshalTest() throws JAXBException {

		final String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><accounts><account><id>2445582204045</id><created_at>2017-10-24T18:10:51Z</created_at><updated_at>2017-10-24T18:10:52Z</updated_at><state>approved</state><org_name>apikeygroup</org_name><extra_fields></extra_fields><credit_card_stored>false</credit_card_stored><plans><plan default=\"true\"><id>2357355905645</id><name>Default</name><type>account_plan</type><state>hidden</state><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan default=\"true\"><id>2357355914980</id><name>Default</name><type>service_plan</type><state>published</state><service_id>2555417749097</service_id><approval_required>false</approval_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan custom=\"true\" default=\"false\"><id>2357355949953</id><name>apikey_application_plan (custom)</name><type>application_plan</type><state>hidden</state><service_id>2555417749097</service_id><end_user_required>false</end_user_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan></plans><users><user><id>2445582364883</id><created_at>2017-10-24T18:10:51Z</created_at><updated_at>2017-10-24T18:10:52Z</updated_at><account_id>2445582204045</account_id><state>active</state><role>admin</role><username>jbutler</username><email>jbutler@redhat.com</email><extra_fields></extra_fields></user></users></account><account><id>2445582561926</id><created_at>2018-06-15T15:45:05Z</created_at><updated_at>2018-06-15T15:46:41Z</updated_at><state>approved</state><org_name>lisa-demo-group</org_name><extra_fields></extra_fields><credit_card_stored>false</credit_card_stored><plans><plan><id>2357355950896</id><name>Default</name><type>service_plan</type><state>published</state><service_id>2555417758485</service_id><approval_required>false</approval_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan><id>2357355950901</id><name>Default</name><type>service_plan</type><state>hidden</state><service_id>2555417758487</service_id><approval_required>false</approval_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan default=\"true\"><id>2357355905645</id><name>Default</name><type>account_plan</type><state>hidden</state><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan default=\"true\"><id>2357355914980</id><name>Default</name><type>service_plan</type><state>published</state><service_id>2555417749097</service_id><approval_required>false</approval_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan custom=\"false\" default=\"true\"><id>2357355950902</id><name>lisa_service_one_app_one</name><type>application_plan</type><state>published</state><service_id>2555417758485</service_id><end_user_required>false</end_user_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan custom=\"false\" default=\"true\"><id>2357355950903</id><name>lisa_service_two_app_one</name><type>application_plan</type><state>published</state><service_id>2555417758487</service_id><end_user_required>false</end_user_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan custom=\"false\" default=\"true\"><id>2357355914995</id><name>apikey_application_plan</name><type>application_plan</type><state>published</state><service_id>2555417749097</service_id><end_user_required>false</end_user_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan custom=\"false\" default=\"false\"><id>2357355950904</id><name>lisa_service_one_app_two</name><type>application_plan</type><state>published</state><service_id>2555417758485</service_id><end_user_required>false</end_user_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan><plan custom=\"false\" default=\"false\"><id>2357355950905</id><name>lisa_service_two_app_two</name><type>application_plan</type><state>published</state><service_id>2555417758487</service_id><end_user_required>false</end_user_required><setup_fee>0.0</setup_fee><cost_per_month>0.0</cost_per_month><trial_period_days/><cancellation_period>0</cancellation_period></plan></plans><users><user><id>2445582731896</id><created_at>2018-06-15T15:45:05Z</created_at><updated_at>2018-06-15T15:45:06Z</updated_at><account_id>2445582561926</account_id><state>active</state><role>admin</role><username>lisa-service-one</username><email>joe_butler@yahoo.com</email><extra_fields></extra_fields></user></users></account></accounts>";

		InputStream is = new ByteArrayInputStream(payload.getBytes());

		JAXBContext context = JAXBContext.newInstance(Accounts.class);
		final Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		Accounts accounts = (Accounts) jaxbUnmarshaller.unmarshal(is);
		List<Account> accountList = accounts.getAccount();
		System.out.println("Id: " + accountList.get(0).getId());


	}

}