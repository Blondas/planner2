package pl.edu.agh.planner.client.common.validators;

import com.smartgwt.client.widgets.form.validator.RegExpValidator;
import pl.edu.agh.planner.shared.AllString;

public class MailAddressValidator extends RegExpValidator {

	public MailAddressValidator() {
		setErrorMessage(AllString.mailValidatorMessage);
		setExpression("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$");
	}

}
