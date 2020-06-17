package member.validate;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.model.Mem;


public class MemValidator implements Validator {
	private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");

	@Override
	public boolean supports(Class<?> clazz) {
		return Mem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "mem.name.empty", "姓名欄位不正確");
		ValidationUtils.rejectIfEmpty(errors, "password", "mem.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "password1", "mem.password1.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "mem.email.empty", "email欄不能空白");

		Mem mem = (Mem) target;
//		String name = customer.getName();
//		if (name == null || name.trim().length() == 0) {
//			errors.rejectValue("name", "customerBean.name.size");
//		}
		
		
		if (mem.getName() != null && mem.getName().length() < 2 || mem.getName().length() > 30) {
			errors.rejectValue("name", "mem.name.size");
		}

		if (mem.getPassword() != null && mem.getPassword().contains(" ")) {
			errors.rejectValue("password", "mem.password.space");
		}

		if (mem.getPassword1() != null && mem.getPassword1().contains(" ")) {
			errors.rejectValue("password1", "mem.password1.space");
		}
		
		if (mem.getPassword1() != null && mem.getPassword1().length() < 5 && mem.getPassword1().length() > 15) {
			errors.rejectValue("password1", "mem.password1.size");
		}
		if (mem.getPassword1() != null && mem.getPassword() != null &&
			!mem.getPassword1().equals(mem.getPassword())
		) {
			errors.rejectValue("password", "mem.password.mustEqual");
		}

		if (mem.getEmail() != null && !EMAIL_REGEX.matcher(mem.getEmail()).matches()) {
			errors.rejectValue("email", "mem.email.invalid");
		}

	}

}
