package com.massmutual.automation.pagespecificlibrary;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.CurrencyValidator;

public class sample {
	
	public static void main(String args[]) {
		/*DecimalFormat df = new DecimalFormat("##,###,###,##0.00");
		String s = "$122,365.00";
		s = s.replace("$", "").replace(",", "");
		
		
		
		String d = df.format(Double.parseDouble(s));
		System.out.println(d);*/
		
		/*BigDecimalValidator validator = CurrencyValidator.getInstance();
		BigDecimal amount = validator.validate("$122,365.24", Locale.US);*/
		
		String money = "122,365.24";
		Pattern p = Pattern.compile("^(?:0|[1-9]\\d{0,2}(?:\\,\\d{3})*).\\d{2}$");
		Matcher m = p.matcher(money);
		if(m.matches())
			System.out.println("valid");
		else
			System.out.println("not valid");
	}

}
